package com.rpm.wework;

import com.alibaba.fastjson.JSON;
import com.rpm.mapper.ChatRecordMapper;
import com.tencent.wework.domain.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/11/3 13:59
 * @version: 1.0
 * @description:
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MessageServiceByMongoTest {

    @Autowired
    ChatRecordMapper mapper;
    @Autowired
    MongoTemplate template;


    @Autowired
    @Qualifier("messageServiceByMongo")
    MessageService messageService;

    @Test
    void save() {
        List<Map> messageList = mapper.selectList();
        List<Message> messages = new ArrayList<>();
        for (Map map : messageList) {
            Message message = JSON.parseObject(map.get("json").toString(), Message.class);
            message.setFileUrl(map.get("fileUrl") == null ? null : map.get("fileUrl").toString());
            messages.add(message);
        }
        messageService.saveAll(messages);

    }

    @Test
    void saveAll() {
        updateFileUrl();
        selectBySender();
        selectByReceiver();
        selectByRoomId();
        selectByRoomIdList();
        selectByTime();
    }

    @Test
    void updateFileUrl() {
        messageService.updateFileUrl("13994635438771967461_1621233960_external", "http://xxx.xxx.com/xxx.docx");
    }

    @Test
    void selectBySender() {
        List<Message> messages = messageService.selectBySender("H032793", new Date(1621231837752L), null);
        System.out.println(messages.size());
    }

    @Test
    void selectByReceiver() {
        List<Message> messages = messageService.selectByReceiver("wmSdo6DAAA_CLvM5qcUlShEzTenc-EGQ", new Date(1621231837752L), null);
        System.out.println(messages.size());
    }

    @Test
    void selectByRoomId() {
        List<Message> messages = messageService.selectByRoomId("wrSdo6DAAA-eDLUB8MMfIFL4yydOveZQ", new Date(1621231837752L), null);
        System.out.println(messages.size());
    }

    @Test
    void selectByRoomIdList() {
        List<String> roomidList = new ArrayList<>();
        roomidList.add("wrSdo6DAAA-eDLUB8MMfIFL4yydOveZQ");
        List<Message> messages = messageService.selectByRoomIdList(roomidList, new Date(1621231837752L), null);
        System.out.println(messages.size());
    }

    @Test
    void selectByTime() {
        List<Message> messages = messageService.selectByTime(new Date(1621231837752L), null);
        System.out.println(messages.size());
    }


}