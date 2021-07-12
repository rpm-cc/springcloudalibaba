package com.rpm.demo.nacosdemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rpm.demo.nacosdemo.handler.BlockHandler;
import com.rpm.demo.nacosdemo.service.RollbackService;
import com.rpm.demo.service.OrderDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Piming Ren
 * @Date 2020/12/15 11:06
 * @Version 1.0
 */

@RestController
@RequestMapping("nacos/")
@RefreshScope
public class NacosDemoController {
    @Value("${data.desc:notExits}")
    String desc;
    @Autowired
    RollbackService rollbackService;
    @Autowired
    OrderDemoService orderDemoService;

    @RequestMapping("hello/world")
    public String nacosHelloWorld() {
        return "Hello World " + desc;
    }

    @RequestMapping("/order/create")
    public String nacosCreateOrder() {

        return rollbackService.createOrder();
    }

    @SentinelResource(value = "sayHello",blockHandlerClass = BlockHandler.class ,blockHandler = "handlerException")
    @RequestMapping("sayHello")
    public String sentinel() {

        return "Hello sentinel";
    }

    @SentinelResource(value = "orderInfo",blockHandler = "blockHandler")
    @RequestMapping("/order/get/{orderId}")
    public String orderInfo(@PathVariable("orderId") String orderId) {
        return orderDemoService.orderInfo(orderId);
    }

    /**
     * 当达到先留后的执行
     * @param orderId
     * @param e 必须
     * @return
     */
    public String blockHandler(String orderId , BlockException e){
        return "流量控制";
    }
}
