package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Piming Ren
 * @Date 2021/1/27 17:15
 * @Version 1.0
 */
@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(){

        System.out.println("Home method run ");

        return "home";
    }



    @GetMapping("/login")
    public String login(){


        return "login";
    }



    @GetMapping("/logout")
    public String logout(){


        return "logout";
    }
}
