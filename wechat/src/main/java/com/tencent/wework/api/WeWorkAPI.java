package com.tencent.wework.api;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 15:54
 * @version: 1.0
 * @description:
 */
public class WeWorkAPI {
    /**
     * 获取accessToken
     * 请求方式 GET(https)
     */
    public static final String GETTOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";

    /**
     *  获取客户群列表
     *  请求方式POST(https)
     */
    public static final String GROUPCHAT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/list?access_token={access_token}";

    /**
     * 获取客户群详情
     * 请求方式POST(https)
     */
    public static final String GROUPCHAT = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/get?access_token={access_token}";
}
