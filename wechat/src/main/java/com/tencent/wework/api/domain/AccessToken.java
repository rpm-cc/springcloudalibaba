package com.tencent.wework.api.domain;
import lombok.Data;


/**
 * @author: Piming Ren
 * @date: 2021/9/23 15:54
 * @version: 1.0
 * @description:
 */
@Data
public class AccessToken extends WeWorkResponse {
    private static final long serialVersionUID = -1694441659920313916L;

    /**
     * 获取到的凭证，最长为512字节
     */
    private String access_token;

    /**
     * 凭证的有效时间（秒）
     */
    private long expires_in;

    @Override
    public String toString() {
        return "AppTokenResult{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
