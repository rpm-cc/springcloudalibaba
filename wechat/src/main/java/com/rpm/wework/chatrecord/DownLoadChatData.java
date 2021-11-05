package com.rpm.wework.chatrecord;

import com.alibaba.fastjson.JSON;
import com.rpm.wework.MessageService;
import com.rpm.wework.config.WeWorkProperties;
import com.tencent.wework.Finance;
import com.tencent.wework.RSAEncrypt;
import com.tencent.wework.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DownLoadChatData {
    private long lastSeq;
    private long sdk;
    @Autowired
    WeWorkProperties weWorkProperties;
    @Autowired
    StringRedisTemplate template;
    @Autowired
    @Qualifier("messageServiceMongo")
    MessageService messageService;
    private long limit;
    private long timeout;
    private String proxy;
    private String passwd;
    private static final String WEWORK_LAST_SEQ = "WEWORK:LAST:SEQ";

    @PostConstruct
    private void init() {
        this.limit = weWorkProperties.getLimit() == 0 ? 999 : weWorkProperties.getLimit();
        this.timeout = weWorkProperties.getTimeout() == 0 ? 50 : weWorkProperties.getTimeout();
        this.proxy = weWorkProperties.getProxy();
        this.passwd = weWorkProperties.getPasswd();
        lastSeq = template.opsForValue().increment(WEWORK_LAST_SEQ, 0);
        this.sdk = Finance.NewSdk();
        long ret = 0;
        ret = Finance.Init(sdk, weWorkProperties.getCorpid(), weWorkProperties.getSecret());
        if (ret != 0) {
            Finance.DestroySdk(sdk);
            log.error("init sdk err ret:{}", ret);
            throw new RuntimeException("init sdk err ret:" + ret);
        }
    }

    public long download() {
        try {
            //第二步 拉取信息
            long slice = Finance.NewSlice();
            int getdata = Finance.GetChatData(
                    sdk,
                    lastSeq,
                    limit,
                    proxy,
                    passwd,
                    timeout, slice);
            if (getdata != 0) {
                Finance.FreeSlice(slice);
                return lastSeq;
            }
            this.getChatdata(slice);
        } catch (Exception e) {
            log.error("Download Failed!!!,error  {}", e);
        } finally {
            Finance.DestroySdk(sdk);
        }
        return lastSeq;
    }

    private void getChatdata(long slice) throws Exception {
        //获取到消息密文
        String encMessage = Finance.GetContentFromSlice(slice);
        //消息密文转化为 json
        ChatDatas chatDatas = JSON.parseObject(encMessage, ChatDatas.class);
        String errmsg = chatDatas.getErrmsg();
        int errcode = chatDatas.getErrcode();
        log.info(" Finance.GetContentFromSlice errcode:{},errrmsg:{}", errcode, errmsg);
        if (errcode == 0) {
            ChatData[] chatdata = chatDatas.getChatdata();
            log.info("Finance.GetContentFromSlice msgsize:{}", chatdata.length);
            List<Message> messages  = new ArrayList<>();
            for (int i = 0; i < chatdata.length; i++) {
                //第三步 解析密文到明文
                ChatData data = chatdata[i];
                String encryptRandomKey = data.getEncryptRandomKey();
                String encryptChatMsg = data.getEncryptChatMsg();
                lastSeq = data.getSeq();
                String encryptKey = RSAEncrypt.decrypt(encryptRandomKey, weWorkProperties.getPrivateKey());
                long subSlice = Finance.NewSlice();
                int ret = Finance.DecryptData(sdk, encryptKey, encryptChatMsg, subSlice);
                if (ret != 0) {
                    log.error("DecryptData Failed:{} error seq:{}", ret, lastSeq);
                    throw new RuntimeException("DecryptData Failed:" + ret + " error seq:" + lastSeq);
                }
                String json = Finance.GetContentFromSlice(subSlice);
                Finance.FreeSlice(subSlice);
                Message message = JSON.parseObject(json, Message.class);
                MsgType msgType = MsgType.of(message.getMsgtype());
                //log.info("Get Message ,messageType is {}",msgType);
                Map<String, String> map = new HashMap<>();
                if (msgType != null) {
                    switch (msgType) {
                        case TEXT:
                            messages.add(message);
                            break;
                        case IMAGE:
                            Image image = message.getImage();
                            map.put("msgid", message.getMsgid());
                            map.put("sdkFileId", image.getSdkfileid());
                            map.put("fileName", message.getMsgid() + ".jpg");
                            MediaDataQueue.INSTANCE.add(map);
                            messages.add(message);
                            break;
                        case FILE:
                            com.tencent.wework.domain.File file = message.getFile();
                            map.put("msgid", message.getMsgid());
                            map.put("sdkFileId", file.getSdkfileid());
                            map.put("fileName", file.getFilename());
                            MediaDataQueue.INSTANCE.add(map);
                            messages.add(message);
                            break;
                        default:
                    }
                } else {
                    //如果没有msgType 说明是切换企业日志
                }

                template.opsForValue().set(WEWORK_LAST_SEQ, lastSeq + "");
                //存储进去mongodb
                messageService.saveAll(messages);
            }
        }
    }


}
