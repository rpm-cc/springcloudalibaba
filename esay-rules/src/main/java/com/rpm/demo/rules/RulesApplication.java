package com.rpm.demo.rules;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author: Piming Ren
 * @date: 2021/7/8 8:54
 * @version: 1.0
 * @description:
 */
@SpringBootApplication
public class RulesApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RulesApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
