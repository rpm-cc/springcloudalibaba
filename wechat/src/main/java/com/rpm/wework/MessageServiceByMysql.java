package com.rpm.wework;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.result.UpdateResult;
import com.tencent.wework.domain.Message;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/11/4 11:43
 * @version: 1.0
 * @description:
 */
@Service
public class MessageServiceByMysql implements MessageService{
    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public Collection<Message> saveAll(List<Message> messageList) throws DuplicateKeyException {
        return null;
    }

    @Override
    public UpdateResult updateFileUrl(String id, String url) {
        return null;
    }

    @Override
    public List<Message> selectBySender(String from, Date beginTime, Date endTime) {
        return null;
    }

    @Override
    public List<Message> selectByReceiver(String receiverId, Date beginTime, Date endTime) {
        return null;
    }

    @Override
    public List<Message> selectByRoomId(String roomId, Date beginTime, Date endTime) {
        return null;
    }

    @Override
    public List<Message> selectByRoomIdList(List<String> roomIdList, Date beginTime, Date endTime) {
        return null;
    }

    @Override
    public List<Message> selectByTime(Date beginTime, Date endTime) {
        return null;
    }
}
