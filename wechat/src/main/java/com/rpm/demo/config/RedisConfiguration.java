package com.rpm.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author: Piming Ren
 * @date: 2021/11/4 9:16
 * @version: 1.0
 * @description:
 */
@Configuration
public class RedisConfiguration {
    @Bean("redisLockRegistyr")
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory factory) {
        //定义了存储在redis中的锁的过期时间！
        //10秒
        Long after = 10000L;
        RedisLockRegistry registry = new RedisLockRegistry(factory, RedisKeyConfig.REDIS_LOCK_KEY,after);
        return registry;
    }
}
