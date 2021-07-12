package com.chtwm.datax.u;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author: Piming Ren
 * @date: 2021/6/1 09:21
 * @version: 1.0
 * @description:
 */
@SpringBootApplication
@EnableScheduling
public class DataxApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DataxApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
