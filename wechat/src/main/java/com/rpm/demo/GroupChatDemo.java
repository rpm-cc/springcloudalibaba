package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.ChatId;
import com.tencent.wework.api.domain.GroupChat;
import com.tencent.wework.api.domain.GroupChatList;
import com.tencent.wework.api.domain.query.GroupChatListQuery;
import com.tencent.wework.api.domain.query.GroupChatQuery;
import com.tencent.wework.api.service.GroupChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public GroupChatList getGroupchatList(String corpid, String secrect, GroupChatListQuery query) {
        GroupChatList groupChatList = restUtil.post(GroupChatList.class,GROUPCHAT_LIST,corpid,secrect,query);
        log.info("GroupChatList:{}", JSON.toJSONString(groupChatList));
        return groupChatList;
    }

    @Override
    public GroupChat getGrroupChat(String corpid, String secrect, GroupChatQuery query) {
        GroupChat groupChat = restUtil.post(GroupChat.class,GROUPCHAT,corpid,secrect,query);
        log.info("GroupChat:{}", JSON.toJSONString(groupChat));
        return groupChat;
    }

    @Override
    public String opengidToChatid(String corpid, String secrect, String opengid) {
        Map<String,Object> data = new HashMap<>();
        data.put("opengid",opengid);
        ChatId chatId = restUtil.post(ChatId.class,OPENGID_TO_CHATID,corpid,secrect,data);
        log.info("ChatId:{}", JSON.toJSONString(chatId));
        return chatId.getChatId();
    }


}
