package com.rpm.wework;



import com.mongodb.DuplicateKeyException;
import com.mongodb.client.result.UpdateResult;
import com.sun.istack.internal.NotNull;
import com.tencent.wework.domain.Message;
import lombok.NonNull;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/11/3 11:00
 * @version: 1.0
 * @description:
 */
public interface MessageService {
    /**
     * 保存 会话记录
     * @param message
     */
     Message save(Message message);

    /**
     * 批量保存会话记录
     * id 重复是会抛org.springframework.dao.DuplicateKeyException异常
     * @param messageList
     */
    Collection<Message> saveAll(List<Message> messageList) throws DuplicateKeyException;

    /**
     * 更新 会话记录媒体文件路径
     * @param id
     * @param url
     */
    UpdateResult updateFileUrl(String id, String url);

    /**
     *  按照时间段和发送人查询会话列表
     * @param from
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Message> selectBySender(String from , Date beginTime , Date endTime);

    /**
     *  按照时间段和接收人查询会话列表
     * @param receiverId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Message> selectByReceiver(String receiverId, Date beginTime ,Date endTime);

    /**
     * 按照房间id和时间段查询会话列表
     * @param roomId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Message> selectByRoomId(String roomId, Date beginTime ,Date endTime);
    /**
     * 按照房间id集合和时间段查询会话列表
     * @param roomIdList
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Message> selectByRoomIdList(List<String> roomIdList,Date beginTime ,Date endTime);

    /**
     * 仅按照时间段查询会话列表
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Message> selectByTime( Date beginTime ,Date endTime);
}
