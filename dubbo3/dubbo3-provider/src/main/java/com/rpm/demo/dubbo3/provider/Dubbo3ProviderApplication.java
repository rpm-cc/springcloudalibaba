package com.rpm.demo.dubbo3.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubbo
public class Dubbo3ProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Dubbo3ProviderApplication.class).web(WebApplicationType.NONE).run(args);
    }

}
