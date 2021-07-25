package com.study.ratelimiter;

public interface RateLimiter {
    boolean tryAcquire();
}
