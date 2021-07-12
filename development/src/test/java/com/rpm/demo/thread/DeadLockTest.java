package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/26 16:08
 * @Version 1.0
 */
public class DeadLockTest {


    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();
        new Thread(new DeadLock("A",a,b)).start();
        new Thread(new DeadLock("B",b,a)).start();

    }
}
