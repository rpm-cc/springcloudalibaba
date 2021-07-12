package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/27 10:08
 * @Version 1.0
 */
public class VolatileTest extends Thread {

    volatile boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stope" + vt.i);
    }
}