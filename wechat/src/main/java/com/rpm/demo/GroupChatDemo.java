package com.rpm.demo;

import com.alibaba.fastjson.JSON;
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
    AccessTokenDemo accessToken;

    @Override
    public GroupChatList getGroupchatList(String corpid, String secrect, GroupChatListQuery query) {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GroupChatList> responseEntity = restTemplate.postForEntity(
                GROUPCHAT_LIST,
                JSON.toJSONString(query),
                GroupChatList.class,
                accessToken.getAccessToken(corpid, secrect));
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("网路错误：{}，获取失败", responseEntity.getStatusCode());
            return null;
        }
        GroupChatList groupChatList = responseEntity.getBody();
        if (groupChatList.getErrcode() != 0) {
            log.error("客户群列表获取失败 errorCode:{} errorMsg:{}", groupChatList.getErrcode(), groupChatList.getErrmsg());
            return null;
        }
        log.info("GroupChatList:{}", JSON.toJSONString(groupChatList));
        return groupChatList;
    }

    @Override
    public GroupChat getGrroupChat(String corpid, String secrect, GroupChatQuery query) {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GroupChat> responseEntity = restTemplate.postForEntity(
                GROUPCHAT,
                JSON.toJSONString(query),
                GroupChat.class,
                accessToken.getAccessToken(corpid, secrect));
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("网路错误：{}，获取失败",responseEntity.getStatusCode());
            return null;
        }
        GroupChat groupChat = responseEntity.getBody();
        if (groupChat.getErrcode() != 0) {
            log.error("客户群详情获取失败 errorCode:{} errorMsg:{}", groupChat.getErrcode(), groupChat.getErrmsg());
            return null;
        }
        log.info("GroupChat:{}", JSON.toJSONString(groupChat));
        return groupChat;
    }

    @Override
    public String opengidToChatid(String corpid, String secrect, String opengid) {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<ChatId> responseEntity = restTemplate.postForEntity(
                OPENGID_TO_CHATID,
                "{\"opengid\":\"" + opengid + "\"}",
                ChatId.class,
                accessToken.getAccessToken(corpid, secrect));
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("网路错误：{}，获取失败",responseEntity.getStatusCode());
            return null;
        }
        ChatId chatId = responseEntity.getBody();
        if (chatId.getErrcode() != 0) {
            log.error("客户群详情获取失败 errorCode:{} errorMsg:{}", chatId.getErrcode(), chatId.getErrmsg());
            return null;
        }
        log.info("ChatId:{}", JSON.toJSONString(chatId));
        return chatId.getChat_id();
    }


}
