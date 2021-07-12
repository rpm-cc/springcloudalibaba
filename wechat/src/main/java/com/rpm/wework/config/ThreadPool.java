package com.rpm.wework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author PimingRen
 * @version 1.0
 * @date 2021/5/12
 */

@Configuration
public class ThreadPool {
    private static final int THREAD_POOL_SIZE = 16;
    private static final int MAX_THREAD_POOL_SIZE = 32;
    private static final int WORKQUEUE_SIZE = 2048;
    private static final String NAME_PREFIX = "chatrecord：";

    @Bean
    public ThreadPoolExecutor create() {
        ThreadFactory threadFactory = new ThreadFactory(NAME_PREFIX);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE, MAX_THREAD_POOL_SIZE,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(WORKQUEUE_SIZE),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

}
