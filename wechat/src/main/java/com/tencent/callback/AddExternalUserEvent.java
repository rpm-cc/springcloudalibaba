package com.tencent.callback;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 14:29
 * @version: 1.0
 * @description:
 */
@Data
@ToString
public class AddExternalUserEvent extends Event {
    @XmlElement(name = "UserID")
    private String userID;
    @XmlElement(name = "ExternalUserID")
    private String externalUserID;
    @XmlElement(name = "State")
    private String state;
    @XmlElement(name = "WelcomeCode")
    private String welcomeCode;
}
