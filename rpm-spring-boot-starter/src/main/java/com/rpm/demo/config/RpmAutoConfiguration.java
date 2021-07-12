package com.rpm.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Piming Ren
 * @date: 2021/6/16 11:44
 * @version: 1.0
 * @description:
 */
@Configuration(proxyBeanMethods = false)
public class RpmAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RpmProperties rpmProperties() {
        return  new RpmProperties();
    }
}
