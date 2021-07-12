package com.rpm.demo.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Piming Ren
 * @Date 2021/1/21 9:55
 * @Version 1.0
 */
public class RpmThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    RpmThreadFactory(String bussiness) {
        this.namePrefix = "RpmThreadFactory-" + bussiness + "-worker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread  = new Thread(null,r,name,0);
        return thread;
    }
}
