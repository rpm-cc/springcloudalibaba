package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.response.external.groupchat.OpengidToChatidResponse;
import com.tencent.wework.api.domain.response.external.groupchat.GroupChatGetResponse;
import com.tencent.wework.api.domain.response.external.groupchat.GroupChatListResponse;
import com.tencent.wework.api.domain.request.external.groupchat.GroupChatListRequest;
import com.tencent.wework.api.domain.request.external.groupchat.GroupChatGetRequest;
import com.tencent.wework.api.service.GroupChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 16:35
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class GroupChatDemo implements GroupChatService {
    @Autowired
    WeWorkRestUtil restUtil;

    @Override
    public GroupChatListResponse getGroupchatList(String corpid, String corpsecret, GroupChatListRequest query) {
        GroupChatListResponse groupChatListResponse = restUtil.post(GroupChatListResponse.class,URL_GROUPCHAT_LIST,corpid,corpsecret,query);
        log.info("GroupChatList:{}", JSON.toJSONString(groupChatListResponse));
        return groupChatListResponse;
    }

    @Override
    public GroupChatGetResponse getGrroupChat(String corpid, String corpsecret, GroupChatGetRequest query) {
        GroupChatGetResponse groupChatGetResponse = restUtil.post(GroupChatGetResponse.class,URL_GROUPCHAT,corpid,corpsecret,query);
        log.info("GroupChat:{}", JSON.toJSONString(groupChatGetResponse));
        return groupChatGetResponse;
    }

    @Override
    public String opengidToChatid(String corpid, String corpsecret, String opengid) {
        Map<String,Object> data = new HashMap<>();
        data.put("opengid",opengid);
        OpengidToChatidResponse opengidToChatidResponse = restUtil.post(OpengidToChatidResponse.class,URL_OPENGID_TO_CHATID,corpid,corpsecret,data);
        log.info("ChatId:{}", JSON.toJSONString(opengidToChatidResponse));
        return opengidToChatidResponse.getChatId();
    }


}
