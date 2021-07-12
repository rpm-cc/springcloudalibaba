package com.rpm.demo.controller;

import com.rpm.demo.dao.domain.OrderInfo;
import com.rpm.demo.dao.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 13:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @RequestMapping("/create")
    public String createOrder(){
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        OrderInfo record = new OrderInfo();
        record.setUserId(1);
        record.setOrderDescr("descr");
        return orderMapper.insert(record)+"_success";
    }

    @RequestMapping("/get/{orderId}")
    public String orderInfo(@PathVariable("orderId") String  orderId){

        return orderId;

    }
}
