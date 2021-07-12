package com.tencent.wework.domain;

import java.util.List;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class Chatrecord {

    /**
     * 聊天记录标题。String类型
     */
    private String title;
    /**
     * 消息记录内的消息内容，批量数据
     */
    private List<Item> item;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Chatrecord{" +
                "title='" + title + '\'' +
                ", item=" + item +
                '}';
    }
    class Item {
        /**
         * 条聊天记录的具体消息类型：
         * ChatRecordText/ ChatRecordFile/ ChatRecordImage/
         * ChatRecordVideo/ ChatRecordLink/
         * ChatRecordLocation/ ChatRecordMixed ….
         */
        private  String type;
        /**
         * 消息时间，utc时间，单位秒。
         */
        private String msgtime;
        /**
         * 消息内容。Json串，内容为对应类型的json。String类型
         */
        private String content;
        /**
         * 是否来自群会话。Bool类型
         */
        Boolean fromChatroom;

        public String getMsgtime() {
            return msgtime;
        }

        public void setMsgtime(String msgtime) {
            this.msgtime = msgtime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Boolean getFromChatroom() {
            return fromChatroom;
        }

        public void setFromChatroom(Boolean fromChatroom) {
            this.fromChatroom = fromChatroom;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "msgtime='" + msgtime + '\'' +
                    ", content='" + content + '\'' +
                    ", fromChatroom=" + fromChatroom +
                    '}';
        }
    }
}
