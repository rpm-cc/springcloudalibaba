package com.rpm.demo.dubbo3.consumer.controller;


import com.rpm.demo.dubbo3.api.Dubbo3Service;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Piming Ren
 * @date: 2021/7/6 18:28
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("demo")
public class Dubbo3Controller {
    @DubboReference
    Dubbo3Service service;
    @RequestMapping("/dubbo3")
    public String demo(){
        return service.dubbo3();
    }

}
