package com.rpm.demo.dubbo.service.impl;

import com.rpm.demo.dubbo.service.DemoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @Author PimingRen
 * @Date 2021/4/23
 * @Version 1.0
 */
@Path("say")
public class DemoServiceImpl  implements DemoService {
    @Path("hello")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public String sayHello() {
        return "Hello!";
    }

}
