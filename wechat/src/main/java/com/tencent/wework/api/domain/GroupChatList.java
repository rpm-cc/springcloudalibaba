package com.tencent.wework.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 16:36
 * @version: 1.0
 * @description:
 */
@Data
public class GroupChatList extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = -2992921970086659415L;
    /**
     * 对返回码的文本描述内容
     */
    private List<Chat> group_chat_list;
    /**
     * 分页游标，下次请求时填写以获取之后分页的记录。如果该字段返回空则表示已没有更多数据
     */
    private String next_cursor;

    @Data
    public static class Chat implements Serializable{
        private static final long serialVersionUID = -8132617887692689042L;
        /**
         * 客户群ID
         */
        private String chat_id;
        /**
         * 客户群跟进状态。
         * 0 - 跟进人正常
         * 1 - 跟进人离职
         * 2 - 离职继承中
         * 3 - 离职继承完成
         */
        private  int status;
    }
}
