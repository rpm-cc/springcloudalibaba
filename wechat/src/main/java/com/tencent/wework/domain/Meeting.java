package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信 邀请会议
 */
public class Meeting {
    /**
     * 会议主题。String类型
     */
    private String topic;
    /**
     * 会议开始时间。Utc时间 单位 s 秒
     */
    private long starttime;
    /**
     * 会议结束时间。Utc时间 单位 s 秒
     */
    private long endtime;
    /**
     * 会议地址。String类型
     */
    private String address;
    /**
     * 会议备注。String类型
     */
    private String remarks;
    /**
     * 会议消息类型。101发起会议邀请消息、102处理会议邀请消息。Uint32类型
     */
    private int meetingtype;
    /**
     * 会议id。方便将发起、处理消息进行对照。uint64类型
     */
    private int meetingid;
    /**
     * 会议邀请处理状态。1 参加会议、2 拒绝会议、3 待定、4 未被邀请、5 会议已取消、6 会议已过期、7 不在房间内。Uint32类型。只有meetingtype为102的时候此字段才有内容。
     */
    private int status;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getMeetingtype() {
        return meetingtype;
    }

    public void setMeetingtype(int meetingtype) {
        this.meetingtype = meetingtype;
    }

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "topic='" + topic + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                ", meetingtype=" + meetingtype +
                ", meetingid=" + meetingid +
                ", status=" + status +
                '}';
    }
}
