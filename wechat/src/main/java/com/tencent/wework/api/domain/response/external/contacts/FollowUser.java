package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:39
 * @version: 1.0
 * @description:
 */
@Data
public class FollowUser {

    /**
     * 添加了此外部联系人的企业成员userid
     */
    private String userid;
    /**
     * 该成员对此外部联系人的备注
     */
    private String remark;
    /**
     * 该成员对此外部联系人的描述
     */
    private String description;
    /**
     * 该成员添加此外部联系人的时间
     */
    private Long createtime;
    /**
     * 该成员添加此外部联系人所打标签
     */
    private List<Tag> tags;
    /**
     * 该成员对此客户备注的企业名称
     */
    @JSONField(name = "remark_crop_name")
    private String remarkCorpName;
    /**
     * 该成员对此客户备注的手机号码，代开发自建应用需要管理员授权才可以获取，第三方不可获取
     */
    @JSONField(name = "remark_mobiles")
    private List<String> remarkMobiles;
    /**
     * 发起添加的userid，如果成员主动添加，为成员的userid；
     * 如果是客户主动添加，则为客户的外部联系人userid；
     * 如果是内部成员共享/管理员分配，则为对应的成员/管理员userid
     */
    @JSONField(name = "oper_userid")
    private String operUserid;
    /**
     * 该成员添加此客户的来源，具体含义详见来源定义
     */
    @JSONField(name = "add_way")
    private Integer addWay;
    /**
     * 企业自定义的state参数，用于区分客户具体是通过哪个「联系我」添加，由企业通过创建「联系我」方式指定
     */
    private String state;

    @Data
    public static class Tag {
        /**
         * 该成员添加此外部联系人所打标签的分组名称（标签功能需要企业微信升级到2.7.5及以上版本）
         */
        @JSONField(name = "group_name")
        private String groupName;
        /**
         * 该成员添加此外部联系人所打标签名称
         */
        @JSONField(name = "tag_name")
        private String tagName;
        /**
         * 该成员添加此外部联系人所打企业标签的id，用户自定义类型标签（type=2）不返回
         */
        @JSONField(name = "tag_id")
        private String tagId;
        /**
         * 该成员添加此外部联系人所打标签类型,
         * 1-企业设置，
         * 2-用户自定义，
         * 3-规则组标签（仅系统应用返回）
         */
        private Integer type;
    }

}
