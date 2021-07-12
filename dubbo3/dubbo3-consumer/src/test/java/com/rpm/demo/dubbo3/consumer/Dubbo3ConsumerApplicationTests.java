package com.rpm.demo.dubbo3.consumer;

import com.rpm.demo.dubbo3.api.Dubbo3Service;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class Dubbo3ConsumerApplicationTests {

    @DubboReference
    Dubbo3Service service;
    @Test
    void contextLoads() {
        System.out.println(service.dubbo3());
    }

}
