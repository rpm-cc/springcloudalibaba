package com.tencent.wework.domain;

import java.util.Arrays;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class Calendar {
    /**
     * 日程主题。String类型
     */
    private String title;
    /**
     * 日程组织者。String类型
     */
    private String creatorname;
    /**
     * 日程参与人。数组，内容为String类型
     */
    private String[] attendeename;
    /**
     * 日程开始时间。Utc时间，单位秒
     */
    private long starttime;
    /**
     * 日程结束时间。Utc时间，单位秒
     */
    private long endtime;
    /**
     * 日程地点。String类型
     */
    private String place;
    /**
     * 日程备注。String类型
     */
    private String remarks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public String[] getAttendeename() {
        return attendeename;
    }

    public void setAttendeename(String[] attendeename) {
        this.attendeename = attendeename;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "title='" + title + '\'' +
                ", creatorname='" + creatorname + '\'' +
                ", attendeename=" + Arrays.toString(attendeename) +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", place='" + place + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
