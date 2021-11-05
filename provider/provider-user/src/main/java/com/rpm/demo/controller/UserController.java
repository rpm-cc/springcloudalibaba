package com.rpm.demo.controller;

import com.rpm.demo.dao.mapper.UserMapper;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 14:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("order/plus")
    public int orderPlus() {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        return mapper.orderPlus(1);
    }
    @RequestMapping("get")
    public String getUser(){

        return  "user";
    }

}
