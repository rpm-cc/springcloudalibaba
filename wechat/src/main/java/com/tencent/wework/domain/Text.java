package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/6
 * @Version 1.0
 *
 * 企业微信文本类型，质包含字段 content
 */
public class Text {
    /**
     * 消息内容。String类型
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
