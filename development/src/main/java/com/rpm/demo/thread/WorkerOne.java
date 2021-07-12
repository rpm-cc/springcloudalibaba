package com.rpm.demo.thread;

/**
 * @Author Piming Ren
 * @Date 2021/1/21 13:30
 * @Version 1.0
 *
 * 尝试一下 wait notify
 */
public class WorkerOne implements Runnable{

    String name ;
    Object prev;
    Object self;

    public WorkerOne(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10 ;
        while (count >0){
            synchronized (prev){
                synchronized (self){
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                    System.out.print(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //当自己不在执行的时候，释放自己持有的锁
        synchronized (self){
            self.notify();
        }
        System.out.println();
        System.out.println(name+"finish");
    }
}
