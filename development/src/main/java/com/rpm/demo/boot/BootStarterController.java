package com.rpm.demo.boot;

import com.rpm.demo.config.RpmProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Piming Ren
 * @date: 2021/6/16 11:34
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/ex")
public class BootStarterController {
    @Autowired
    RpmProperties config;
    @RequestMapping("/boot/starter")
    public String bootStarter(){


        return config.toString();

    }
}
