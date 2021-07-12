package com.rpm.demo.nacosdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping("/user/order/plus")
    public String user(){
        return "demo";
    }
}
