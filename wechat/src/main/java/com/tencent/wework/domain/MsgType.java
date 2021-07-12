package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/8
 * @Version 1.0
 */
public enum MsgType {

    /**
     * 消息类型，取值范围：
     * 1 text 文本 ，2 image 图片 ，3 revoke 撤回消息，4 agree 同意会话存档， 5 disagree 不同意会话存档
     * 6 voice 语音，7 video 视频，8 card 名片，9 location 位置，10 emotion 表情，11 file 文件
     * 12 link 链接，13 weapp 小程序消息，14 chatrecord 会话记录，15 “_todo” 代办,16 vote 投票消息，17 collect 填表消息
     * 18 redpacket 红包 ，19 meeting 会议邀请，20 docmsg 在线文档消息，21 markdown MarkDown格式消息
     * 22 news 图文消息，23 calendar 日程消息， 24 mixed 混合消息，25 meeting_voice_call 音频存档消息
     * 26 voip_doc_share 音频共享文档消息，27external_redpacket 互通红包
     * 28 sphfeed 视频号消息
     */
    TEXT("text"),
    IMAGE("image"),
    REVOKE("revoke"),
    AGREE("agree"),
    DISAGREE("disagree"),
    VOICE("voice"),
    VIDEO("video"),
    CARD("card"),
    LOCATION("location"),
    EMOTION("emotion"),
    FILE("file"),
    LINK("link"),
    WEAPP("weapp"),
    CHARRECORD("chatrecord"),
    _TODO("todo"),
    VOTE("vote"),
    COLLECT("collect"),
    REDPACKET("redpacket"),
    MEETING("meeting"),
    DOCMSG("docmsg"),
    MARKDOWN("markdown"),
    NEWS("news"),
    CALENDAR("calendar"),
    MIXED("mixed"),
    METTING_VOICE_CALL("metting_voice_call"),
    VOIP_DOC_SHARE("voip_doc_share"),
    EXTERNAL_REDPACKET("external_redpacket"),
    SPHFEED("sphfeed");


    MsgType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static MsgType of(String name) {
        if (name == null || name == "") {
            return null;
        }
        for (MsgType msgType : MsgType.values()) {
            if (msgType.getName().equals(name)) {
                return msgType;
            }
        }
        return null;
    }
}
