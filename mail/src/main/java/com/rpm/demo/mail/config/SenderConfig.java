package com.rpm.demo.mail.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Piming Ren
 * @date: 2021/6/17 17:47
 * @version: 1.0
 * @description:
 */
@Configuration
@ConfigurationProperties("chtwm.mail")
public class SenderConfig {
}
