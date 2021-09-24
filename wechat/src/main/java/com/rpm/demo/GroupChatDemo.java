package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.tencent.wework.api.WeWorkAPI;
import com.tencent.wework.api.domain.GroupChat;
import com.tencent.wework.api.domain.GroupChatList;
import com.tencent.wework.api.domain.query.GroupChatListQuery;
import com.tencent.wework.api.domain.query.GroupChatQuery;
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
public class GroupChatDemo {

    @Autowired
    AccessTokenDemo accessToken;

    public GroupChatList getGroupchatList(String corpid, String secrect , GroupChatListQuery query) {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GroupChatList> responseEntity = restTemplate.postForEntity(
                WeWorkAPI.GROUPCHAT_LIST,
                JSON.toJSONString(query),
                GroupChatList.class,
                accessToken.getAccessToken(corpid, secrect));
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("获取失败");

        }
        GroupChatList groupChatList = responseEntity.getBody();
        if (groupChatList.getErrcode() != 0) {
            log.error("AccessToken获取失败 errorCode:{} errorMsg:{}", groupChatList.getErrcode(), groupChatList.getErrmsg());
            return null;
        }
        log.info("GroupChatList:{}", JSON.toJSONString(groupChatList));
        return groupChatList;
    }

    public GroupChat getGrroupChat(String corpid, String secrect , GroupChatQuery query){
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GroupChat> responseEntity = restTemplate.postForEntity(
                WeWorkAPI.GROUPCHAT,
                JSON.toJSONString(query),
                GroupChat.class,
                accessToken.getAccessToken(corpid, secrect));
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("获取失败");

        }
        GroupChat groupChat = responseEntity.getBody();
        if (groupChat.getErrcode() != 0) {
            log.error("AccessToken获取失败 errorCode:{} errorMsg:{}", groupChat.getErrcode(), groupChat.getErrmsg());
            return null;
        }
        log.info("GroupChat:{}", JSON.toJSONString(groupChat));
        return groupChat;
    }



}
