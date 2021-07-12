package com.tencent.wework.domain;

import java.util.Arrays;

/**
 * @Author PimingRen
 * @Date 2021/5/6
 * @Version 1.0
 */
public class ChatDatas {

    //{
    // "errcode":0,
    // "errmsg":"ok",
    // "chatdata":[
    //     {"seq":196,
    //      "msgid":"CAQQ2fbb4QUY0On2rYSAgAMgip/yzgs=",
    //      "publickey_ver":3,
    //      "encrypt_random_key":"ftJ+uz3n/z1DsxlkwxNgE+mL38H42/KCvN8T60gbbtPD+Rta1hKTuQPzUzO6Hzne97MgKs7FfdDxDck/v8cDT6gUVjA2tZ/M7euSD0L66opJ/IUeBtpAtvgVSD5qhlaQjvfKJc/zPMGNK2xCLFYqwmQBZXbNT7uA69Fflm512nZKW/piK2RKdYJhRyvQnA1ISxK097sp9WlEgDg250fM5tgwMjujdzr7ehK6gtVBUFldNSJS7ndtIf6aSBfaLktZgwHZ57ONewWq8GJe7WwQf1hwcDbCh7YMG8nsweEwhDfUz+u8rz9an+0lgrYMZFRHnmzjgmLwrR7B/32Qxqd79A==",
    //      "encrypt_chat_msg":"898WSfGMnIeytTsea7Rc0WsOocs0bIAerF6de0v2cFwqo9uOxrW9wYe5rCjCHHH5bDrNvLxBE/xOoFfcwOTYX0HQxTJaH0ES9OHDZ61p8gcbfGdJKnq2UU4tAEgGb8H+Q9n8syRXIjaI3KuVCqGIi4QGHFmxWenPFfjF/vRuPd0EpzUNwmqfUxLBWLpGhv+dLnqiEOBW41Zdc0OO0St6E+JeIeHlRZAR+E13Isv9eS09xNbF0qQXWIyNUi+ucLr5VuZnPGXBrSfvwX8f0QebTwpy1tT2zvQiMM2MBugKH6NuMzzuvEsXeD+6+3VRqL"
    //     }
    // ]
    // }


    int errcode;
    String errmsg;
    ChatData[] chatdata;


    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public ChatData[] getChatdata() {
        return chatdata;
    }

    public void setChatdata(ChatData[] chatdata) {
        this.chatdata = chatdata;
    }

    @Override
    public String toString() {
        return "ChatDatas{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", chatdata=" + Arrays.toString(chatdata) +
                '}';
    }
}
