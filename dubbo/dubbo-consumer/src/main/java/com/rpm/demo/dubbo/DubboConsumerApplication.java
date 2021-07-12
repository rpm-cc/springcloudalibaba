package com.rpm.demo.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author PimingRen
 * @Date 2021/4/23
 * @Version 1.0
 */

@SpringBootApplication
@ImportResource({"classpath:spring/dubbo-consumer.xml"})
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
