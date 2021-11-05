package com.rpm.wework;


import com.mongodb.client.result.UpdateResult;
import com.tencent.wework.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/11/3 11:18
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class MessageServiceByMongo implements MessageService {
    @Autowired
    MongoTemplate template;

    @Override
    public Message save(Message message) {
        Message save = template.save(message);
        return save;
    }

    @Override
    public Collection<Message> saveAll(List<Message> messageList) {
        Collection<Message> messages = null;
        try {
            messages = template.insertAll(messageList);
        } catch (Exception e) {
            if (e instanceof org.springframework.dao.DuplicateKeyException
                    || e instanceof com.mongodb.DuplicateKeyException) {
                //如果出现主键冲突 需要遍历插入。
                log.warn("Has A DuplicateKeyException:{}{}", e,e.getClass().getName());
                log.warn("Has A DuplicateKeyException retry single save {}!","kdkfjksjkjfkksjkfajskdfj");

                messages = new ArrayList<>();
                for (Message message : messageList) {
                    message = save(message);
                    messages.add(message);
                }
            }else {
                log.error("saveAll error {}",e);
            }
        }


        return messages;
    }

    @Override
    public UpdateResult updateFileUrl(String id, String url) {
        UpdateResult upsert = template.upsert(new Query(new Criteria("msgid").is(id)), Update.update("fileUrl", url), Message.class);
        upsert.getMatchedCount();
        return upsert;
    }

    @Override
    public List<Message> selectBySender(String from, Date beginTime, Date endTime) {
        Assert.notNull(beginTime, "beginTime is must not null");
        if (endTime == null) {
            endTime = new Date();
        }
        Criteria criteria = Criteria.where("from").is(from).and("msgtime").gte(beginTime.getTime()).lte(endTime.getTime());
        return template.find(new Query(criteria), Message.class);
    }

    @Override
    public List<Message> selectByReceiver(String receiverId, Date beginTime, Date endTime) {
        Assert.notNull(beginTime, "beginTime is must not null");
        if (endTime == null) {
            endTime = new Date();
        }
        Criteria criteria = Criteria.where("tolist").in(receiverId).and("msgtime").gte(beginTime.getTime()).lte(endTime.getTime());
        return template.find(new Query(criteria), Message.class);
    }

    @Override
    public List<Message> selectByRoomId(String roomId, Date beginTime, Date endTime) {
        Assert.notNull(beginTime, "beginTime is must not null");
        if (endTime == null) {
            endTime = new Date();
        }
        Criteria criteria = Criteria.where("roomid").is(roomId).and("msgtime").gte(beginTime.getTime()).lte(endTime.getTime());
        return template.find(new Query(criteria), Message.class);
    }

    @Override
    public List<Message> selectByRoomIdList(List<String> roomIdList, Date beginTime, Date endTime) {
        Assert.notNull(beginTime, "beginTime is must not null");
        if (endTime == null) {
            endTime = new Date();
        }
        Criteria criteria = Criteria.where("roomid").in(roomIdList).and("msgtime").gte(beginTime.getTime()).lte(endTime.getTime());
        return template.find(new Query(criteria), Message.class);
    }

    @Override
    public List<Message> selectByTime(Date beginTime, Date endTime) {
        Assert.notNull(beginTime, "beginTime is must not null");
        if (endTime == null) {
            endTime = new Date();
        }
        Criteria criteria = Criteria.where("msgtime").gte(beginTime.getTime()).lte(endTime.getTime());
        return template.find(new Query(criteria), Message.class);
    }


}
