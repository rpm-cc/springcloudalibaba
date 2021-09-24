package com.tencent.wework.api.domain.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 8:54
 * @version: 1.0
 * @description:
 */
@Data
public class GroupChatQuery {
    /**
     * 客户群ID
     */
    private String chat_id;
    /**
     * 是否需要返回群成员的名字group_chat.member_list.name。0-不返回；1-返回。默认不返回
     */
    private Integer need_name;

    public static GroupChatQuery.Builder builder() {
        return new GroupChatQuery.Builder();
    }

    public static class Builder {
        GroupChatQuery query;

        Builder() {
            query = new GroupChatQuery();
        }

        public GroupChatQuery.Builder setChatId(String chatId) {
            query.setChat_id(chatId);
            return this;
        }

        public GroupChatQuery.Builder setLimit(Integer needName) {
            query.setNeed_name(needName);
            return this;
        }
        public GroupChatQuery build(){
            return query;
        }

    }
}
