package com.tencent.wework.domain;
/**
 * @author Piming Ren
 * @date 2021/5/12
 * @version 1.0
 */
public class ChatData {
    long seq;
    String msgid;
    int publickeyVer;
    String encryptRandomKey;
    String encryptChatMsg;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public int getPublickeyVer() {
        return publickeyVer;
    }

    public void setPublickeyVer(int publickeyVer) {
        this.publickeyVer = publickeyVer;
    }

    public String getEncryptRandomKey() {
        return encryptRandomKey;
    }

    public void setEncryptRandomKey(String encryptRandomKey) {
        this.encryptRandomKey = encryptRandomKey;
    }

    public String getEncryptChatMsg() {
        return encryptChatMsg;
    }

    public void setEncryptChatMsg(String encryptChatMsg) {
        this.encryptChatMsg = encryptChatMsg;
    }

    @Override
    public String toString() {
        return "ChatData{" +
                "seq=" + seq +
                ", msgid='" + msgid + '\'' +
                ", publickeyVer=" + publickeyVer +
                ", encryptRandomKey='" + encryptRandomKey + '\'' +
                ", encryptChatMsg='" + encryptChatMsg + '\'' +
                '}';
    }
}