package com.rpm.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 13:04
 * @Version 1.0
 */
@FeignClient("provider-order")
public interface OrderDemoService {

    @RequestMapping("/order/create")
    String createOrder();

    @RequestMapping("/order/get/{orderId}")
    String orderInfo(@PathVariable(value = "orderId") String orderId);

}
