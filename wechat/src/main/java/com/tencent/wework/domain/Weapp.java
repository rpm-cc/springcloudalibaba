package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信 小程序类型
 */
public class Weapp {
    /**
     * 消息标题。String类型
     */
    private String title;
    /**
     * 消息描述。String类型
     */
    private String description;
    /**
     * 用户名称。String类型
     */
    private String username;
    /**
     * 小程序名称。String类型
     */
    private String displayname;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @Override
    public String toString() {
        return "Weapp{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", displayname='" + displayname + '\'' +
                '}';
    }
}
