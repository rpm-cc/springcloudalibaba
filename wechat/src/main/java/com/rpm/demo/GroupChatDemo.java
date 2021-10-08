package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.response.external.groupchat.OpengidToChatidResponse;
import com.tencent.wework.api.domain.response.external.groupchat.GetGroupChatResponse;
import com.tencent.wework.api.domain.response.external.groupchat.GroupChatListResponse;
import com.tencent.wework.api.domain.request.external.groupchat.GroupChatListRequest;
import com.tencent.wework.api.domain.request.external.groupchat.GetGroupChatRequest;
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
        GroupChatListResponse response = restUtil.post(GroupChatListResponse.class,URL_GROUPCHAT_LIST,corpid,corpsecret,query);
        log.info("GroupChatList:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public GetGroupChatResponse getGrroupChat(String corpid, String corpsecret, GetGroupChatRequest query) {
        GetGroupChatResponse response = restUtil.post(GetGroupChatResponse.class,URL_GROUPCHAT,corpid,corpsecret,query);
        log.info("GroupChat:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public String opengidToChatid(String corpid, String corpsecret, String opengid) {
        Map<String,Object> data = new HashMap<>();
        data.put("opengid",opengid);
        OpengidToChatidResponse response = restUtil.post(OpengidToChatidResponse.class,URL_OPENGID_TO_CHATID,corpid,corpsecret,data);
        log.info("ChatId:{}", JSON.toJSONString(response));
        return response.getChatId();
    }


}
