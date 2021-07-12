package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/26 16:06
 * @Version 1.0
 */
public class DeadLock implements Runnable {
    String name ;
    Object pre = new Object();
    Object self  = new Object();

    public DeadLock(String name,  Object self,Object pre) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {

        synchronized (pre){

            System.out.println(name+"begin");
            try {
                //死锁的情况。锁超时，自动释放
                pre.wait(5100);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }

    }
}
