package com.rpm.demo.dubbo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author PimingRen
 * @Date 2021/4/23
 * @Version 1.0
 */

@SpringBootApplication
@ImportResource({"classpath:spring/dubbo-provider.xml"})
public class DubboProviderApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
