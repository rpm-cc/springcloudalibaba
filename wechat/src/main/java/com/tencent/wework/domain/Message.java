package com.tencent.wework.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Arrays;

/**
 * @Author PimingRen
 * @Date 2021/5/6
 * @Version 1.0
 */
@Document(collection = "chatrecord")
public class Message {
    /**
     * 消息id，消息的唯一标识，企业可以使用此字段进行消息去重。String类型
     */
    @MongoId
    private String msgid;
    /**
     * 消息动作，目前有send(发送消息)/recall(撤回消息)/switch(切换企业日志)三种类型。String类型
     */
    private String action;
    /**
     * 消息发送方id。同一企业内容为userid，非相同企业为external_userid。消息如果是机器人发出，也为external_userid。String类型
     */
    private String from;
    /**
     * 消息接收方列表，可能是多个，同一个企业内容为userid，非相同企业为external_userid。数组，内容为string类型
     */
    private String[] tolist;
    /**
     * 聊消息的群id。如果是单聊则为空。String类型
     */
    private String roomid;
    /**
     * 消息发送时间戳，utc时间，ms单位。
     */
    private long msgtime;
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
    private String msgtype;
    /**
     * 音频id 对应meeting_voice_call 类型
     */
    private String voiceid;
    /**
     * String类型, 音频id 对应 voip_doc_share
     */
    private String voipid;

    /**
     * 媒体文件类型等，需要下载并上传到fastdfs 服务器中的文件url。
     */
    private String fileUrl;
    /**
     * 文本类型
     */
    Text text;
    /**
     * 图片类型
     */
    Image image;
    /**
     * 撤回消息
     */
    Revoke revoke;
    /**
     * 同意会话存档
     */
    Agree agree;
    /**
     * 不同意会话存档
     */
    Disagree disagree;
    /**
     * 语音消息
     */
    Voice voice;
    /**
     * 视频
     */
    Video video;
    /**
     * 名片
     */
    Card card;
    /**
     * 位置
     */
    Location location;
    /**
     * 表情
     */
    Emotion emotion;
    /**
     * 文件
     */
    File file;
    /**
     * 链接
     */
    Link link;
    /**
     * 小程序
     */
    Weapp weapp;
    /**
     * 会话记录
     */
    Chatrecord chatrecord;
    /**
     * 代办
     */
    @JSONField(name = "todo")
    WantTodo wantTodo;
    /**
     * 投票
     */
    Vote vote;
    /**
     * 图文
     */
    Collect collect;
    /**
     * 红包和互通红包
     */
    Redpacket redpacket;
    /**
     * 会议邀请
     */
    Meeting meeting;
    /**
     * 在线文档
     */
    Doc doc;

    /**
     * markdown Or 图文消息
     */
    @JSONField(name = "info")
    NewsOrMarkDown newsOrMarkDown;
    /**
     * 日程
     */
    Calendar calendar;
    /**
     * 混合
     */
    Mixed mixed;
    /**
     * 事实音频 音频存档
     */
    MeetingVoiceCall meetingVoiceCall;
    /**
     * 音频共享文档消息
     */
    VoipDocShare voipDocShare;
    /**
     * 视频号
     */
    Sphfeed sphfeed;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTolist() {
        return tolist;
    }

    public void setTolist(String[] tolist) {
        this.tolist = tolist;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public long getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(long msgtime) {
        this.msgtime = msgtime;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getVoiceid() {
        return voiceid;
    }

    public void setVoiceid(String voiceid) {
        this.voiceid = voiceid;
    }

    public String getVoipid() {
        return voipid;
    }

    public void setVoipid(String voipid) {
        this.voipid = voipid;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Revoke getRevoke() {
        return revoke;
    }

    public void setRevoke(Revoke revoke) {
        this.revoke = revoke;
    }

    public Agree getAgree() {
        return agree;
    }

    public void setAgree(Agree agree) {
        this.agree = agree;
    }

    public Disagree getDisagree() {
        return disagree;
    }

    public void setDisagree(Disagree disagree) {
        this.disagree = disagree;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Weapp getWeapp() {
        return weapp;
    }

    public void setWeapp(Weapp weapp) {
        this.weapp = weapp;
    }

    public Chatrecord getChatrecord() {
        return chatrecord;
    }

    public void setChatrecord(Chatrecord chatrecord) {
        this.chatrecord = chatrecord;
    }

    public WantTodo getWantTodo() {
        return wantTodo;
    }

    public void setWantTodo(WantTodo wantTodo) {
        this.wantTodo = wantTodo;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

    public Redpacket getRedpacket() {
        return redpacket;
    }

    public void setRedpacket(Redpacket redpacket) {
        this.redpacket = redpacket;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }


    public NewsOrMarkDown getNewsOrMarkDown() {
        return newsOrMarkDown;
    }

    public void setNewsOrMarkDown(NewsOrMarkDown newsOrMarkDown) {
        this.newsOrMarkDown = newsOrMarkDown;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Mixed getMixed() {
        return mixed;
    }

    public void setMixed(Mixed mixed) {
        this.mixed = mixed;
    }

    public MeetingVoiceCall getMeetingVoiceCall() {
        return meetingVoiceCall;
    }

    public void setMeetingVoiceCall(MeetingVoiceCall meetingVoiceCall) {
        this.meetingVoiceCall = meetingVoiceCall;
    }

    public VoipDocShare getVoipDocShare() {
        return voipDocShare;
    }

    public void setVoipDocShare(VoipDocShare voipDocShare) {
        this.voipDocShare = voipDocShare;
    }

    public Sphfeed getSphfeed() {
        return sphfeed;
    }

    public void setSphfeed(Sphfeed sphfeed) {
        this.sphfeed = sphfeed;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgid='" + msgid + '\'' +
                ", action='" + action + '\'' +
                ", from='" + from + '\'' +
                ", tolist=" + Arrays.toString(tolist) +
                ", roomid='" + roomid + '\'' +
                ", msgtime=" + msgtime +
                ", msgtype='" + msgtype + '\'' +
                ", voiceid='" + voiceid + '\'' +
                ", voipid='" + voipid + '\'' +
                ", text=" + text +
                ", fileUrl" + fileUrl +
                ", image=" + image +
                ", revoke=" + revoke +
                ", agree=" + agree +
                ", disagree=" + disagree +
                ", voice=" + voice +
                ", video=" + video +
                ", card=" + card +
                ", location=" + location +
                ", emotion=" + emotion +
                ", file=" + file +
                ", link=" + link +
                ", weapp=" + weapp +
                ", chatrecord=" + chatrecord +
                ", wantTodo=" + wantTodo +
                ", vote=" + vote +
                ", collect=" + collect +
                ", redpacket=" + redpacket +
                ", meeting=" + meeting +
                ", doc=" + doc +
                ", newsOrMarkDown=" + newsOrMarkDown +
                ", calendar=" + calendar +
                ", mixed=" + mixed +
                ", meetingVoiceCall=" + meetingVoiceCall +
                ", voipDocShare=" + voipDocShare +
                ", sphfeed=" + sphfeed +
                '}';
    }

    public static void main(String[] args) {
        //转化测试
        String textJson = "{\"msgid\":\"CAQQluDa4QUY0On2rYSAgAMgzPrShAE=\",\"action\":\"send\",\"from\":\"XuJinSheng\",\"tolist\":[\"icefog\"],\"roomid\":\"\",\"msgtime\":1547087894783,\"msgtype\":\"text\",\"text\":{\"content\":\"test\"}}\n";
        Message textMessage = JSON.parseObject(textJson, Message.class);
        System.out.println(textMessage);
        String imageJson = "{\"msgid\":\"CAQQvPnc4QUY0On2rYSAgAMgooLa0Q8=\",\"action\":\"send\",\"from\":\"XuJinSheng\",\"tolist\":[\"icefog\"],\"roomid\":\"\",\"msgtime\":0,\"msgtype\":\"image\",\"image\":{\"md5sum\":\"50de8e5ae8ffe4f1df7a93841f71993a\",\"filesize\":70961,\"sdkfileid\":\"CtYBMzA2OTAyMDEwMjA0NjIzMDYwMDIwMTAwMDIwNGI3ZmU0MDZlMDIwMzBmNTliMTAyMDQ1YzliNTQ3NzAyMDQ1YzM3M2NiYzA0MjQ2NjM0MzgzNTM0NjEzNTY1MmQzNDYxMzQzODJkMzQzMTYxNjEyZDM5NjEzOTM2MmQ2MTM2NjQ2NDY0NjUzMDY2NjE2NjM1MzcwMjAxMDAwMjAzMDExNTQwMDQxMDUwZGU4ZTVhZThmZmU0ZjFkZjdhOTM4NDFmNzE5OTNhMDIwMTAyMDIwMTAwMDQwMBI4TkRkZk1UWTRPRGcxTVRBek1ETXlORFF6TWw4eE9UUTVOamN6TkRZMlh6RTFORGN4TWpNNU1ERT0aIGEwNGQwYWUyM2JlYzQ3NzQ5MjZhNWZjMjk0ZTEyNTkz\"}}\n";
        Message imgeMessage = JSON.parseObject(imageJson, Message.class);
        System.out.println(imgeMessage);
        String revokeJson = "{\"msgid\":\"15775510700152506326_1603875615\",\"action\":\"recall\",\"from\":\"kenshin\",\"tolist\":[\"wmUu0zBgAALV7ZymkcMyxvbTe8YdWxxA\"],\"roomid\":\"\",\"msgtime\":1603875615723,\"msgtype\":\"revoke\",\"revoke\":{\"pre_msgid\":\"14822339130656386894_1603875600\"}}\n";
        Message revokeMessage = JSON.parseObject(revokeJson, Message.class);
        System.out.println(revokeMessage);

        String json = "{\"msgid\":\"118732825779547782215\",\"action\":\"send\",\"from\":\"kens\",\"tolist\":[\"icef\",\"test\"],\"roomid\":\"wrErxtDgAA0jgXE5\",\"msgtime\":1603876045165,\"msgtype\":\"news\",\"info\":{\"item\":[{\"title\":\"service \",\"description\":\"test\",\"url\":\"http://xxx\",\"picurl\":\"https://www.qq.com/xxx.jpg\"}]}}";
        Message message = JSON.parseObject(json, Message.class);
        System.out.println(message);
        String markdown = "{\"msgid\":\"7546287934688259248_1603875715\",\"action\":\"send\",\"from\":\"ken\",\"tolist\":[\"icef\",\"test\"],\"roomid\":\"wr0SfLCgAAgCaCPeM33UNe\",\"msgtime\":1603875715782,\"msgtype\":\"markdown\",\"info\":{\"content\":\"请前往系统查看，谢谢。\"}}";
        Message message2 = JSON.parseObject(markdown, Message.class);
        System.out.println(message2);

    }

}
