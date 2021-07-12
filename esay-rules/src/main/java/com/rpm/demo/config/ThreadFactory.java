package com.rpm.demo.config;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PimingRen
 * @version 1.0
 * @date 2021/5/12
 */
public class ThreadFactory implements java.util.concurrent.ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public ThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix+nextId.getAndIncrement();
        Thread thread = new Thread(null,r,name,0);
        return thread;
    }
}
