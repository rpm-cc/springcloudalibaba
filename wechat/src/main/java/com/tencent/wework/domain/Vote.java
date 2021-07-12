package com.tencent.wework.domain;

import java.util.Arrays;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信投票消息
 */
public class Vote {
    /**
     * 	投票主题。String类型
     */
    private String votetitle;
    /**
     * 投票选项，可能多个内容。String数组
     */
    private String[] voteitem;
    /**
     * 投票类型.101发起投票、102参与投票。Uint32类型
     */
    private int votetype	;
    /**
     * 	投票id，方便将参与投票消息与发起投票消息进行前后对照。String类型
     */
    private String  voteid;

    public String getVotetitle() {
        return votetitle;
    }

    public void setVotetitle(String votetitle) {
        this.votetitle = votetitle;
    }

    public String[] getVoteitem() {
        return voteitem;
    }

    public void setVoteitem(String[] voteitem) {
        this.voteitem = voteitem;
    }

    public int getVotetype() {
        return votetype;
    }

    public void setVotetype(int votetype) {
        this.votetype = votetype;
    }

    public String getVoteid() {
        return voteid;
    }

    public void setVoteid(String voteid) {
        this.voteid = voteid;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "votetitle='" + votetitle + '\'' +
                ", voteitem=" + Arrays.toString(voteitem) +
                ", votetype=" + votetype +
                ", voteid='" + voteid + '\'' +
                '}';
    }
}
