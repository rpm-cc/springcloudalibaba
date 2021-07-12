package com.rpm.demo.dubbo.controller;

import com.rpm.demo.dubbo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author PimingRen
 * @Date 2021/4/23
 * @Version 1.0
 */
@RestController
@RequestMapping("demo/")
@Slf4j
public class DemoController {


//    @DubboReference(methods = @Method(
//            name = "sayHello",
//            oninvoke = "notifyImpl.oninvoke",
//            onreturn = "notifyImpl.onreturn",
//            onthrow = "notifyImpl.onthrow"
//    ))
    @Autowired
    DemoService demoService;

    @RequestMapping("sayHello")
    public String sayHello() {

        RpcContext context = RpcContext.getContext();
        String res = null;
        try {
            res = demoService.sayHello();
            log.info(res);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }
}
