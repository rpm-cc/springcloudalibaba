package com.rpm.demo.boot.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Piming Ren
 * @date: 2021/7/1 15:46
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/example")
public class GatewayController {

       @RequestMapping("/one")
       public String exampleOne(){

           System.out.println("exampleOne");
           return "exampleOne";
       }
}
