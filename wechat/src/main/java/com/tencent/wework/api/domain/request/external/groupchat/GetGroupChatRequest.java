package com.tencent.wework.api.domain.request.external.groupchat;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 8:54
 * @version: 1.0
 * @description:
 */
@Data
public class GetGroupChatRequest implements WeWorkRequest, Serializable {
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

    public static GetGroupChatRequest.Builder builder() {
        return new GetGroupChatRequest.Builder();
    }

    public static class Builder {
        GetGroupChatRequest request;

        Builder() {
            request = new GetGroupChatRequest();
        }

        public GetGroupChatRequest.Builder chatId(String chatId) {
            request.setChatId(chatId);
            return this;
        }

        public GetGroupChatRequest.Builder needName(Integer needName) {
            request.setNeedName(needName);
            return this;
        }
        public GetGroupChatRequest build(){
            return request;
        }

    }
}
