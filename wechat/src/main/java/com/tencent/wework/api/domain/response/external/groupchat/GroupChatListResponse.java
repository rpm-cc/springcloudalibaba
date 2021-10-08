package com.tencent.wework.api.domain.response.external.groupchat;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
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
public class GroupChatListResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = -2992921970086659415L;
    /**
     * 对返回码的文本描述内容
     */
    @JSONField(name = "group_chat_list")
    private List<Chat> groupChatList;
    /**
     * 分页游标，下次请求时填写以获取之后分页的记录。如果该字段返回空则表示已没有更多数据
     */
    @JSONField(name = "next_cursor")
    private String nextCursor;

    @Data
    public static class Chat implements Serializable{
        private static final long serialVersionUID = -8132617887692689042L;
        /**
         * 客户群ID
         */
        @JSONField(name = "chat_id")
        private String chatId;
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
