package com.rpm.demo.mail.controller;

import com.rpm.demo.mail.service.DefaultMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Piming Ren
 * @date: 2021/6/16 18:19
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    DefaultMailSender defaultMailSender;
    @RequestMapping("send")
    public void send(){
        defaultMailSender.send();

    }
    @RequestMapping("/mix/send")
    public void mixSend(){
        defaultMailSender.sendMime();
    }
}
