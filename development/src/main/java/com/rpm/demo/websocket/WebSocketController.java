package com.rpm.demo.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @Author Piming Ren
 * @Date 2021/3/17 9:58
 * @Version 1.0
 */
@ServerEndpoint("/wsk/time/{userId}")
@Component
public class WebSocketController extends TextWebSocketHandler {

    @OnOpen
    public void open(){

        System.out.println("WEBSOCKET onOpen");
    }

    @OnClose
    public void close(){
        System.out.println("WEBSOCKET onClose");
    }

    @OnMessage
    public void message(String message){
        System.out.println("WEBSOCKET onMessage:"+message);

    }
    @OnError
    public void error(Throwable error){
        System.out.println("WEBSOCKET onError");
        error.printStackTrace();

    }


}
