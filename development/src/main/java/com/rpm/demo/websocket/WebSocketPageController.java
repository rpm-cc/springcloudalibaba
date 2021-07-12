package com.rpm.demo.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Piming Ren
 * @Date 2021/3/17 10:35
 * @Version 1.0
 */
@Controller
@RequestMapping("/wsk")
public class WebSocketPageController {

    @RequestMapping("/receive")
    public String receive(){


        return "receive";
    }
}
