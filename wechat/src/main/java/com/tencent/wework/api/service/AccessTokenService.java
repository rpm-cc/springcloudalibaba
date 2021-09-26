package com.tencent.wework.api.service;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 10:13
 * @version: 1.0
 * @description:
 */
public interface AccessTokenService {
    /**
     * <pre>
     * 获取accessToken
     * 请求方式 GET(https)
     * 详见：https://open.work.weixin.qq.com/api/doc/10013#%E7%AC%AC%E4%B8%89%E6%AD%A5%EF%BC%9A%E8%8E%B7%E5%8F%96access_token
     * </pre>
     */
     String API_URI = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";

    /**
     * 获取accesstoken  注意 accessToken 的有效期
     * @param corpid  企业ID
     * @param corpsecret  应用密钥
     * @return String 返回有效的access token
     *
     */
     String getAccessToken(String corpid,String corpsecret);
}
