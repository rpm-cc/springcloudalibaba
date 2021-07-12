package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 视频号消息
 */
public class Sphfeed {

    /**
     * 视频号消息类型。2 图片、4 视频、9 直播。Uint32类型
     */
    private int feedType;
    /**
     * 视频号账号名称。String类型
     */
    private String sphName;
    /**
     * 视频号消息描述。String类型
     */
    private String feedDesc;

    public int getFeedType() {
        return feedType;
    }

    public void setFeedType(int feedType) {
        this.feedType = feedType;
    }

    public String getSphName() {
        return sphName;
    }

    public void setSphName(String sphName) {
        this.sphName = sphName;
    }

    public String getFeedDesc() {
        return feedDesc;
    }

    public void setFeedDesc(String feedDesc) {
        this.feedDesc = feedDesc;
    }

    @Override
    public String toString() {
        return "Sphfeed{" +
                "feedType=" + feedType +
                ", sphName='" + sphName + '\'' +
                ", feedDesc='" + feedDesc + '\'' +
                '}';
    }
}
