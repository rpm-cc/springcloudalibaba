package com.rpm.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 13:47
 * @Version 1.0
 */
@FeignClient("provider-user")
public interface UserDemoService {

    @RequestMapping("/user/order/plus")
    int orderplus();
}
