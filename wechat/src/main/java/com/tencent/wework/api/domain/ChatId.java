package com.tencent.wework.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 11:06
 * @version: 1.0
 * @description:
 */
@Data
public class ChatId extends WeWorkResponse {
    /**
     * opengidToChatid  转换时获取到的客户群ID
     */
    @JSONField(name = "chat_id")
    private String chatId;
}
