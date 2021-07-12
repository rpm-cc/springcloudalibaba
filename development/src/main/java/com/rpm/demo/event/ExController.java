package com.rpm.demo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author PimingRen
 * @Date 2021/4/1
 * @Version 1.0
 */

@RestController
@RequestMapping("/ex")
public class ExController {

    @Resource
    private  ApplicationContext context;
    @GetMapping("/event")
    public String event(){

        context.publishEvent(new ExEvent(this,"push"));
        return "publish";
    }

}
