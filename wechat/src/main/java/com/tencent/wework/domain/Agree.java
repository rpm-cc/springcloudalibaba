package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信 同意存档会话内容
 * nihao
 */
public class Agree {
    /**
     * 同意协议者的userid，外部企业默认为external_userid。String类型
     */
    private String userid;
    /**
     * 同意协议的时间，utc时间，ms单位。
     * 原始json中的字段名称是 agree_time,
     */
    private long agreeTime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(long agreeTime) {
        this.agreeTime = agreeTime;
    }

    @Override
    public String toString() {
        return "Disagree{" +
                "userid='" + userid + '\'' +
                ", agreeTime=" + agreeTime +
                '}';
    }
}
