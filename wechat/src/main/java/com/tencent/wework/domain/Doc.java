package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class Doc {
    /**
     * 在线文档名称
     */
    private String title;
    /**
     * 在线文档链接
     */
    private String linkUrl;
    /**
     * 在线文档创建者。本企业成员创建为userid；外部企业成员创建为external_userid
     */
    private String docCreator;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDocCreator() {
        return docCreator;
    }

    public void setDocCreator(String docCreator) {
        this.docCreator = docCreator;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "title='" + title + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", docCreator='" + docCreator + '\'' +
                '}';
    }
}
