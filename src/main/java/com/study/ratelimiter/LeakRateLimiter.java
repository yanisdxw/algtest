package com.study.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 漏桶算法
 */
public class LeakRateLimiter implements RateLimiter {
    //定义桶的大小
    private long bucketSize;
    //计数器
    private AtomicLong counter = new AtomicLong(0);
    //流出速率: 个/100ms
    private long outRate;

    public LeakRateLimiter(long bucketSize, long outRate){
        this.bucketSize = bucketSize;
        this.outRate = outRate;
        Worker worker = new Worker();
        new Thread(worker).start();
    }

    @Override
    public boolean tryAcquire() {
        if(counter.get()>bucketSize){
            System.out.println("refuse_request");
            return false;
        }else {
            System.out.println("pass_request");
            counter.incrementAndGet();
            return true;
        }
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            while (true){
                System.out.println("bucket remain:"+counter.get());
                if(counter.get()>outRate){
                    counter.addAndGet(-outRate);
                    System.out.println("");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    counter.set(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeakRateLimiter leakRateLimiter = new LeakRateLimiter(2000,20);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        for (int j = 0; j < 1000; j++) {
                            leakRateLimiter.tryAcquire();
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
