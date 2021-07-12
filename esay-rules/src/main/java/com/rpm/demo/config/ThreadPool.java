package com.rpm.demo.config;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author PimingRen
 * @version 1.0
 * @date 2021/5/12
 */


public class ThreadPool {
    private static final int THREAD_POOL_SIZE = 16;
    private static final int MAX_THREAD_POOL_SIZE = 32;
    private static final int WORKQUEUE_SIZE = 2048;
    private static final String NAME_PREFIX = "thread-";
    private static ThreadPoolExecutor instance;
//    private String prefix;
//    private int poolSize;
//    private int maxPoolSize;
//    private int queueSize;
//    private ThreadPool(String prefix,int poolSize,int maxPoolSize,int queueSize) {
//        this.prefix  = prefix;
//        this.poolSize = poolSize;
//        this.maxPoolSize = maxPoolSize;
//        this.queueSize  = queueSize;
//    }
//
    public static ThreadPoolExecutor instance() {
        if (instance == null) {
            //同步锁 再次进行校验
            synchronized (ThreadPoolExecutor.class) {
                if (instance == null) {
                    ThreadFactory threadFactory = new ThreadFactory(NAME_PREFIX);
                    instance = new ThreadPoolExecutor(THREAD_POOL_SIZE, MAX_THREAD_POOL_SIZE,
                            5L,
                            TimeUnit.SECONDS,
                            new LinkedBlockingDeque<>(WORKQUEUE_SIZE),
                            threadFactory,
                            new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return instance;
    }
}
