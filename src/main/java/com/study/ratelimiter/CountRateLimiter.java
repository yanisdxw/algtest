package com.study.ratelimiter;

import java.util.concurrent.atomic.AtomicLong;

/***
 * 计数器算法
 */
public class CountRateLimiter implements RateLimiter {

    /**计算器*/
    private AtomicLong counter = new AtomicLong(0);
    /**初始时间*/
    private static long timestamp = System.currentTimeMillis();
    /**时间窗口内最大请求个数*/
    private long limit;

    public CountRateLimiter(long limit) {
        this.limit = limit;
    }

    @Override
    public boolean tryAcquire() {
        long now = System.currentTimeMillis();
        //1s之内的请求
        if (now - timestamp < 1000) {
            if (counter.get() < limit) {
                counter.incrementAndGet();
                System.out.println("pass_request");
                return true;
            } else {
                System.out.println("refuse_request");
                return false;
            }
        } else {
            counter = new AtomicLong(0);
            timestamp = now;
            System.out.println("time_end,refuse_request");
            return false;
        }
    }
}
