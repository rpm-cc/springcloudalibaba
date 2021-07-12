package com.rpm.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author Piming Ren
 * @Date 2021/3/3 9:37
 * @Version 1.0
 */
public class Write {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel server  = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8001));
        server.configureBlocking(false);

        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);







    }







}
