package com.rpm.wework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author PimingRen
 * @version 1.0
 * @date 2021/5/12
 */
@Data
@Configuration("weWorkProperties")
@ConfigurationProperties(prefix = "wework")
public class WeWorkProperties {
    /**
     * 企业微信，企业ID
     */

    private String corpid;
    /**
     * 企业微信，绘画存档secret
     */

    private String secret;
    /**
     * 企业微信 ，消息加密私钥
     */
    private String privateKey;
    /**
     * 如果使用代理，代理的地址
     */
    private String proxy;
    /**
     * 如果使用代理，代理的密码
     */
    private String passwd;
    /**
     * limit of get datas
     */
    private long limit;
    /**
     * timeout
     */
    private long timeout;

}
