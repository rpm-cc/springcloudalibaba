package com.rpm.mapper;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import com.tencent.wework.domain.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Map> messageList = mapper.selectList();
        List<Message> messages = new ArrayList<>();
        for (Map map : messageList) {
            Message message = JSON.parseObject(map.get("json").toString(), Message.class);
            message.setFileUrl(map.get("fileUrl") == null ? null : map.get("fileUrl").toString());
            messages.add(message);
            template.save(message);
        }

    }

    @Test
    public void save() {
        List<Map> messageList = mapper.selectList();
        List<Message> messages = new ArrayList<>();
        for (Map map : messageList) {
            Message message = JSON.parseObject(map.get("json").toString(), Message.class);
            message.setFileUrl(map.get("fileUrl") == null ? null : map.get("fileUrl").toString());
            messages.add(message);
        }
        template.insertAll(messages);
    }

    @Test
    public void mongoSelect() {
//        Query query = new Query();
//        Criteria criteria = Criteria.where("tolist").in("H0327931");
//        query.addCriteria(criteria);
//        List<Message> messageList = template.find(query, Message.class, "chatrecord");
        Criteria criteria = Criteria.where("tolist").in("H032793").and("msgtime").gte(null).lte(null);
        List<Message> messageList = template.find(new Query(criteria), Message.class);
        System.out.println(messageList);
    }


    @Test
    public void mongoSelectById() {
        //Message message = template.findOne(new Query(new Criteria("_id").is("32132654028142845_1621214808_external")),Message.class,"chatrecord");
        Message message = template.findOne(new Query(new Criteria("msgid").is("10248969675563750111_1621231837_external")), Message.class, "chatrecord");
        System.out.println(message);


    }

    @Test
    public void mongoUpdateById() {
        UpdateResult upsert = template.upsert(new Query(new Criteria("msgid").is("10248969675563750111_1621231837_external")),
                Update.update("fileUrl", "http://file.chtfund.com.cn/group2/M00/00/2E/rBDFX2CjkYqEIsE_AAAAAA5ocJY546.jpg"),
                Message.class);
        System.out.println(upsert);

    }


    @Test
    public void mongoSelectByIdList() {
        Query query = new Query();
        List<String> idList = new ArrayList<>();
        idList.add("10248969675563750111_1621231837_external");
        idList.add("712150557292492326_1621331441_external");
        Criteria criteria = Criteria.where("msgid").in(idList);
        query.addCriteria(criteria);
        List<Message> me = template.find(query, Message.class);
        System.out.println(me);
    }


    // 实验聚合查询

    @Test
    void aggreate() {
        //举例:查询一个群组中，每个接收人接收到的消息数量。
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("roomid").is("wrSdo6DAAA-eDLUB8MMfIFL4yydOveZQ")),
                Aggregation.unwind("tolist"),
                Aggregation.group("tolist").count().as("count"),
                Aggregation.project("count").and("userid").previousOperation()
        );
        AggregationResults<Map> chatrecord = template.aggregate(aggregation, Message.class, Map.class);
        List<Map> mappedResults = chatrecord.getMappedResults();
        for (Map map : mappedResults) {
            System.out.println("用户：" + map.get("userid") + "   接收到的会话数量:" + map.get("count"));
        }
        //TypedAggregation 这个方式和上面的方式实现效果看起来是一样。
        TypedAggregation aggregation2 = TypedAggregation.newAggregation(Message.class, Aggregation.match(Criteria.where("roomid").is("wrSdo6DAAA-eDLUB8MMfIFL4yydOveZQ")),
                Aggregation.unwind("tolist"),
                Aggregation.group("tolist").count().as("count"),
                Aggregation.project("count").and("userid").previousOperation());
        AggregationResults<Map> typeChatrecord = template.aggregate(aggregation2, Map.class);
        mappedResults = typeChatrecord.getMappedResults();
        for (Map map : mappedResults) {
            System.out.println("用户：" + map.get("userid") + "   接收到的会话数量:" + map.get("count"));
        }
    }
}
