package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信  名片类型
 */
public class Card {
    /**
     *名片所有者所在的公司名称。String类型
     */
   private String corpname;
    /**
     *名片所有者的id，同一公司是userid，不同公司是external_userid。String类型
     */
   private String  userid;

    public String getCorpname() {
        return corpname;
    }

    public void setCorpname(String corpname) {
        this.corpname = corpname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
