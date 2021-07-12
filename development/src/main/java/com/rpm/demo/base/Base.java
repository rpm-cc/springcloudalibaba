package com.rpm.demo.base;

public class Base {

    public static int g_connect_timeout;
    public static int g_network_timeout;

    public Base() {

    }

    public static void init(int x ,int y) {
          g_connect_timeout = x;
          g_network_timeout = y;

    }


    public static void out(){

        System.out.println("g_connect_timeout:"+g_connect_timeout);
        System.out.println("g_network_timeout:"+g_network_timeout);
    }

}
