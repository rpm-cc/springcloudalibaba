package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/26 15:02
 * @Version 1.0
 */
public class WorkOneTest {

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread t1 = new Thread(new WorkerOne("A", c, a));
        Thread t2 = new Thread(new WorkerOne("B", a, b));
        Thread t3 = new Thread(new WorkerOne("C", b, c));

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
        Thread.sleep(100);
    }


}
