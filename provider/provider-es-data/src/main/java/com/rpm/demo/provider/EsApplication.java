package com.rpm.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Piming Ren
 * @Date 2020/12/31 9:22
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
    }

}