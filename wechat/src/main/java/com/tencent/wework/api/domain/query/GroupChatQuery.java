package com.tencent.wework.api.domain.query;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 8:54
 * @version: 1.0
 * @description:
 */
@Data
public class GroupChatQuery implements Query, Serializable {
    private static final long serialVersionUID = 8913618304429099690L;
    /**
     * 客户群ID
     */
    @JSONField(name = "chat_id")
    private String chatId;
    /**
     * 是否需要返回群成员的名字group_chat.member_list.name。0-不返回；1-返回。默认不返回
     */
    @JSONField(name = "need_name")
    private Integer needName;

    public static GroupChatQuery.Builder builder() {
        return new GroupChatQuery.Builder();
    }

    public static class Builder {
        GroupChatQuery query;

        Builder() {
            query = new GroupChatQuery();
        }

        public GroupChatQuery.Builder setChatId(String chatId) {
            query.setChatId(chatId);
            return this;
        }

        public GroupChatQuery.Builder setNeedName(Integer needName) {
            query.setNeedName(needName);
            return this;
        }
        public GroupChatQuery build(){
            return query;
        }

    }
}
