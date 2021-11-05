package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:36
 * @version: 1.0
 * @description:
 */
@Data
public class ExternalProfile {
    /**
     * 企业对外简称，需从已认证的企业简称中选填。可在“我的企业”页中查看企业简称认证状态。
     */
    @JSONField(name = "external_crop_name")
    private String externalCropName;
    /**
     * 视频号属性。须从企业绑定到企业微信的视频号中选择，
     * 可在“我的企业”页中查看绑定的视频号。第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取。
     * 注意：externalcontact/get不返回该字段
     */
    @JSONField(name = "wechat_channels")
    private WechatChannels wechatChannels;
    /**
     * 属性列表，目前支持文本、网页、小程序三种类型
     */
    @JSONField(name = "external_attr")
    private List<ExternalAttr> externalAttr;
    @Data
    public static class ExternalAttr{
        /**
         * 属性类型: 0-文本 1-网页 2-小程序
         */
        private Integer type;
        /**
         * 属性名称： 需要先确保在管理端有创建该属性，否则会忽略
         */
        private String name;
        /**
         * 文本类型的属性
         */
        private Text text;
        /**
         * 网页类型的属性，url和title字段要么同时为空表示清除该属性，要么同时不为空
         */
        private Web web;
        /**
         * 小程序类型的属性，appid和title字段要么同时为空表示清除该属性，要么同时不为空
         */
        private Miniprogram miniprogram;

    }
    @Data
    public static class WechatChannels{
        /**
         * 视频号名字（设置后，成员将对外展示该视频号）
         */
        private String nickname;
        /**
         * 对外展示视频号状态。0表示企业视频号已被确认，可正常使用，1表示企业视频号待确认
         */
        private Integer status;
    }
    @Data
    public static class Text{
        /**
         * 文本属性内容，长度限制32个UTF8字符
         */
        private String value;
    }
    @Data
    public static class Web{
        /**
         * 网页的url，必须包含http或者https头
         */
        private String url;
        /**
         * 网页的展示标题，长度限制12个UTF8字符
         */
        private String title;
    }
    @Data
    public static class  Miniprogram{
        /**
         * 小程序appid，必须是有在本企业安装授权的小程序，否则会被忽略
         */
        private String appid;
        /**
         * 小程序的展示标题，长度限制12个UTF8字符
         */
        private String pagepath;
        /**
         * 小程序的页面路径
         */
        private String title;
    }
}