package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/27 9:35
 * @Version 1.0
 */
public class ThreadLocalTest {
    static ThreadLocal<Integer> local = new ThreadLocal<>();


    public static void main(String[] args) {
        local.set(1);
        //if set value here   ,the value is main Thread
        System.out.println("main:" + local.get());
        new Thread(() -> {
            local.set(100);
            for (int i = 0; i < 20; i++) {
                Integer pre = local.get();
                System.out.println("pre:" + pre);
                local.set(pre + 1);
            }
        }).start();
        new Thread(() -> {
            local.set(200);
            for (int i = 0; i < 20; i++) {
                Integer pre = local.get();
                System.out.println("pre:" + pre);
                local.set(pre + 10);
            }
        }).start();
    }
}
