package com.study.ratelimiter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**滑动窗算法*/
public class SlidingRateLimiter implements RateLimiter {

    /**滑动窗数量*/
    private int windowsSize;
    /**每个窗口的时间片大小 单位ms*/
    private long unit;
    /**整个限制窗口内的数量*/
    private long limit;

    private LoadingCache<Long, AtomicLong> counter =
            CacheBuilder.newBuilder()
                    .expireAfterWrite(10, TimeUnit.SECONDS)
                    .build(new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long seconds) throws Exception {
                            return new AtomicLong(0);
                        }
                    });

    public SlidingRateLimiter(long unit, int windowsSize, long limit){
        this.unit = unit;
        this.windowsSize = windowsSize;
        this.limit = limit;
    }

    @Override
    public boolean tryAcquire() {
        long now = System.currentTimeMillis();
        try {
            counter.get(now).incrementAndGet();
            long nums = 0;
            for (int i = 0; i < windowsSize; i++) {
                nums += counter.get(now-i*unit).get();
            }
            if(nums>limit){
                System.out.println("refuse_request");
                return false;
            }
        }catch (Exception e){

        }
        System.out.println("pass_request");
        return true;
    }

    public static void main(String[] args) {
        SlidingRateLimiter slidingRateLimiter = new SlidingRateLimiter(200,5,200);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        for (int j = 0; j < 1000; j++) {
                            slidingRateLimiter.tryAcquire();
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
