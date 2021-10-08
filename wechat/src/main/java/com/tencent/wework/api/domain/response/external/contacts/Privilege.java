package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 11:29
 * @version: 1.0
 * @description:
 */
@Data
public class Privilege implements Serializable {
    private static final long serialVersionUID = -8287155329166928881L;
    @JSONField(name = "view_customer_list")
    private Boolean viewCustomerList;
    @JSONField(name = "view_customer_data")
    private Boolean viewCustomerData;
    @JSONField(name = "view_room_list")
    private Boolean viewRoomList;
    @JSONField(name = "contact_me")
    private Boolean contactMe;
    @JSONField(name = "join_room")
    private Boolean joinRoom;
    @JSONField(name = "share_customer")
    private Boolean shareCustomer;
    @JSONField(name = "oper_resign_customer")
    private Boolean operResignCustomer;
    @JSONField(name = "oper_resign_group")
    private Boolean operResignGroup;
    @JSONField(name = "send_customer_msg")
    private Boolean sendCustomerMsg;
    @JSONField(name = "edit_welcome_msg")
    private Boolean editWelcomeMsg;
    @JSONField(name = "view_behavior_data")
    private Boolean viewBehaviorData;
    @JSONField(name = "view_room_data")
    private Boolean viewRoomData;
    @JSONField(name = "send_group_msg")
    private Boolean sendGroupMsg;
    @JSONField(name = "room_deduplication")
    private Boolean roomDeduplication;
    @JSONField(name = "rapid_reply")
    private Boolean rapidReply;
    @JSONField(name = "onjob_customer_transfer")
    private Boolean onjobCustomerTransfer;
    @JSONField(name = "edit_anti_spam_rule")
    private Boolean editAntiSpamRule;
    @JSONField(name = "export_customer_list")
    private Boolean exportCustomerList;
    @JSONField(name = "export_customer_data")
    private Boolean exportCustomerData;
    @JSONField(name = "export_customer_group_list")
    private Boolean exportCustomerGroupList;
    @JSONField(name = "manage_customer_tag")
    private Boolean manageCustomerTag;

}
