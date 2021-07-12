package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 *
 * 红包消息
 */
public class Redpacket {
    /**
     * 红包消息类型。1 普通红包、2 拼手气群红包。Uint32类型
     */
    private int type;
    /**
     * 红包祝福语。String类型
     */
    private String wish;
    /**
     * 红包总个数。Uint32类型
     */
    private int totalcnt;
    /**
     * 红包总金额。Uint32类型，单位为分。
     */
    private int totalamount;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public int getTotalcnt() {
        return totalcnt;
    }

    public void setTotalcnt(int totalcnt) {
        this.totalcnt = totalcnt;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    @Override
    public String toString() {
        return "ExternalRedpacket{" +
                "type=" + type +
                ", wish='" + wish + '\'' +
                ", totalcnt=" + totalcnt +
                ", totalamount=" + totalamount +
                '}';
    }
}
