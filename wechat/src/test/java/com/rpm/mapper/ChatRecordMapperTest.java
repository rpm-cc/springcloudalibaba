package com.rpm.mapper;

import com.alibaba.fastjson.JSON;
import com.tencent.wework.domain.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 13:51
 * @version: 1.0
 * @description:
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@MapperScan("com.rpm.mapper")
public class ChatRecordMapperTest {
    @Autowired
    ChatRecordMapper mapper;
    @Autowired
    MongoTemplate template;

    @Test
    public void selectList() {
        List<String> messageList = mapper.selectList();
        for (String megJson : messageList) {
            Message message = JSON.parseObject(megJson, Message.class);
            template.save(message, "chatrecord");
        }

    }

    @Test
    public void mongoSelect() {
        Query query  = new Query();
        Criteria criteria  = Criteria.where("tolist").in("H0327931");
        query.addCriteria(criteria);
        List<Message> messageList = template.find(query,Message.class,"chatrecord");

        System.out.println(messageList);
    }


    @Test
    public void mongoSelectById(){
        //Message message = template.findOne(new Query(new Criteria("_id").is("32132654028142845_1621214808_external")),Message.class,"chatrecord");
        Message message = template.findOne(new Query(new Criteria("msgid").is("32132654028142845_1621214808_external")),Message.class,"chatrecord");
        System.out.println(message);


    }
}
