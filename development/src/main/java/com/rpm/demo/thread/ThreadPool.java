package com.rpm.demo.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Piming Ren
 * @Date 2021/1/21 10:03
 * @Version 1.0
 */
@Configuration
public class ThreadPool {


    private static final int THREAD_POOL_SIZE=16;
    @Bean
    public ThreadPoolExecutor create(){
        RpmThreadFactory threadFactory = new RpmThreadFactory("rpm");
        ThreadPoolExecutor executor  = new ThreadPoolExecutor(THREAD_POOL_SIZE,THREAD_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

}
