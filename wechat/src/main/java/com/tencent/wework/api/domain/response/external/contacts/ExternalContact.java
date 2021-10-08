package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:36
 * @version: 1.0
 * @description:
 */
@Data
public class ExternalContact {
    /**
     * 外部联系人的userid
     */
    @JSONField(name = "external_userid")
    private String externalUserid;
    /**
     * 外部联系人的名称
     * 如果是微信用户，则返回其微信昵称。如果是企业微信联系人，则返回其设置对外展示的别名或实名
     */
    private String name;
    /**
     * 外部联系人头像，代开发自建应用需要管理员授权才可以获取，第三方不可获取
     */
    private String avatar;
    /**
     * 外部联系人的类型，1表示该外部联系人是微信用户，2表示该外部联系人是企业微信用户
     */
    private Integer type;
    /**
     * 外部联系人性别 0-未知 1-男性 2-女性
     */
    private Integer gender;
    /**
     * 外部联系人在微信开放平台的唯一身份标识（微信unionid），
     * 通过此字段企业可将外部联系人与公众号/小程序用户关联起来。
     * 仅当联系人类型是微信用户，且企业或第三方服务商绑定了微信开发者ID有此字段
     */
    private String unionid;
    /**
     * 外部联系人的职位，如果外部企业或用户选择隐藏职位，则不返回
     * 仅当联系人类型是企业微信用户时有此字段
     */
    private String position;
    /**
     * 外部联系人所在企业的简称
     * 仅当联系人类型是企业微信用户时有此字段
     */
    @JSONField(name = "corp_name")
    private String corpName;
    /**
     * 外部联系人所在企业的简称
     * 仅当联系人类型是企业微信用户时有此字段
     */
    @JSONField(name = "corp_full_name")
    private String corpFullName;
    /**
     * 外部联系人的自定义展示信息，可以有多个字段和多种类型，包括文本，网页和小程序，
     * 仅当联系人类型是企业微信用户时有此字段，字段详情见对外属性；
     */
    @JSONField(name = "external_profile")
    private ExternalProfile externalProfile;



}
