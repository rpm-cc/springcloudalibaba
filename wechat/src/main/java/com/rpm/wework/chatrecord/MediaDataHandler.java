package com.rpm.wework.chatrecord;

import com.rpm.wework.config.WeWorkProperties;
import com.tencent.wework.Finance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Component
public class MediaDataHandler {

    @Autowired
    ThreadPoolExecutor executor;
    @Autowired
    WeWorkProperties properties;
    /**
     * 处理队列
     */

    /**
     * 执行带有文件的各种消息类型的消息，进行文件处理
     * 开启线程
     */
    public void invoke() {
        long sdk = Finance.NewSdk();
        long ret = Finance.Init(sdk, properties.getCorpid(), properties.getSecret());
        if (ret != 0) {
            Finance.DestroySdk(sdk);
            log.error("init sdk err ret:{}", ret);
            throw new RuntimeException("init sdk err ret:" + ret);
        }
        while (true) {
            try {
                Map<String, String> map = MediaDataQueue.INSTANCE.get().take();
                executor.execute(new SaveFile(map, properties, sdk));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解密，保存文件
     */
    class SaveFile implements Runnable {
        Map<String, String> map;
        WeWorkProperties properties;
        long sdk;

        public SaveFile(Map<String, String> map, WeWorkProperties properties, long sdk) {
            this.map = map;
            this.properties = properties;
            this.sdk = sdk;
        }

        @Override
        public void run() {
            log.info("thread name{} begin", Thread.currentThread().getName());
            saveFile(map);
        }

        private void saveFile(Map<String, String> map) {
            String sdkFileId = map.get("sdkFileId");
            String FileName = map.get("fileName");
            String indexbuf = "";
            FileName = "D:\\data\\" + FileName;

            while (true) {
                //每次使用GetMediaData拉取存档前需要调用NewMediaData获取一个media_data，在使用完media_data中数据后，还需要调用FreeMediaData释放。
                long mediaData = Finance.NewMediaData();
                int ret = Finance.GetMediaData(sdk, indexbuf, sdkFileId, properties.getProxy(), properties.getPasswd(), 30, mediaData);
                if (ret != 0) {
                    log.error("getmediadata ret{},map:{}",ret,map);
                    Finance.FreeMediaData(mediaData);
                    MediaDataQueue.INSTANCE.add(map);
                    throw new RuntimeException("init sdk err ret:" + ret);
                }
                log.info("getmediadata outindex len:{}, data_len:{}, is_finis:{}", Finance.GetIndexLen(mediaData), Finance.GetDataLen(mediaData), Finance.IsMediaDataFinish(mediaData));
                try {
                    //大于512k的文件会分片拉取，此处需要使用追加写，避免后面的分片覆盖之前的数据。
                    FileOutputStream outputStream = new FileOutputStream(new java.io.File(FileName), true);
                    outputStream.write(Finance.GetData(mediaData));
                    outputStream.close();
                } catch (Exception e) {
                    log.error("Save File Filed {}", e);
                }

                if (Finance.IsMediaDataFinish(mediaData) == 1) {
                    //已经拉取完成最后一个分片
                    Finance.FreeMediaData(mediaData);
                    break;
                } else {
                    //获取下次拉取需要使用的indexbuf
                    indexbuf = Finance.GetOutIndexBuf(mediaData);
                    Finance.FreeMediaData(mediaData);
                }
            }
        }
    }
}
