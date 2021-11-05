package com.rpm.demo.config;

/**
 * @author: Piming Ren
 * @date: 2021/11/4 9:19
 * @version: 1.0
 * @description:
 */
public class RedisKeyConfig {
    public static final String REDIS_LOCK_KEY = "lock";

    public static String getRedisLockKey(String customerKey) {

        return REDIS_LOCK_KEY + ":" + customerKey;
    }
}
