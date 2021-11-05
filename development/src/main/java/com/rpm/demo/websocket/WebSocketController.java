package com.rpm.demo.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @Author Piming Ren
 * @Date 2021/3/17 9:58
 * @Version 1.0
 */
@ServerEndpoint("/wsk/time/{userId}")
@Component
public class WebSocketController extends TextWebSocketHandler {

    private static int onLineCount = 0;

    @OnOpen
    public void open(Session session){
    ;
        onLineCount ++;

        System.out.println("WEBSOCKET onOpen count:"+onLineCount);
    }

    @OnClose
    public void close(){
        onLineCount --;
        System.out.println("WEBSOCKET onClose");
    }

    @OnMessage
    public void message(Session session,String message) throws IOException {
        session.getBasicRemote().sendText("服务器收到的："+message);
        System.out.println("WEBSOCKET onMessage:"+message);

    }
    @OnError
    public void error(Throwable error){
        System.out.println("WEBSOCKET onError");
        error.printStackTrace();

    }


}
