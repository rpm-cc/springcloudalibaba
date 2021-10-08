package com.tencent.wework.api.domain;
import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
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
    @JSONField(name = "access_token")
    private String accessToken;

    /**
     * 凭证的有效时间（秒）
     */
    @JSONField(name = "expires_in")
    private long expiresIn;

}
