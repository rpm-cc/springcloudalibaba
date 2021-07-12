package com.rpm.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/6/30 9:07
 * @version: 1.0
 * @description:
 */
public class MyRateLimiter implements RateLimiter {
    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        return null;
    }

    @Override
    public Map getConfig() {
        return null;
    }

    @Override
    public Class getConfigClass() {
        return null;
    }

    @Override
    public Object newConfig() {
        return null;
    }
}
