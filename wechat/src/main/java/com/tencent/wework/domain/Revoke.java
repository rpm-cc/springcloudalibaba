package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 撤回消息
 */
public class Revoke {
    /**
     * 标识撤回的原消息的msgid。String类型
     */
    private String preMsgid;

    public String getPreMsgid() {
        return preMsgid;
    }

    public void setPreMsgid(String preMsgid) {
        this.preMsgid = preMsgid;
    }

    @Override
    public String toString() {
        return "Revoke{" +
                "preMsgid='" + preMsgid + '\'' +
                '}';
    }
}
