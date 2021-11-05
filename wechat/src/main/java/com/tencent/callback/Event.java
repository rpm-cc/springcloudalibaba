package com.tencent.callback;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 14:54
 * @version: 1.0
 * @description:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
@Data
public class Event implements Serializable {
    private static final long serialVersionUID = 4591520529447718618L;
    @XmlElement(name = "ToUserName")
    protected String toUserName;
    @XmlElement(name = "FromUserName")
    protected String fromUserName;
    @XmlElement(name = "CreateTime")
    protected Long createTime;
    @XmlElement(name = "MsgType")
    protected String msgType;
    @XmlElement(name = "Event")
    protected String event;
    @XmlElement(name = "ChangeType")
    protected String changeType;
}
