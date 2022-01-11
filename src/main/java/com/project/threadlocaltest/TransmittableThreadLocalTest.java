package com.project.threadlocaltest;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalTest {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private TransmittableThreadLocal<Integer> transmittableThreadLocal = new TransmittableThreadLocal<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void test1(){
        threadLocal.set(1);
        transmittableThreadLocal.set(1);
        Thread t = new Thread(new Worker());
        t.start();
    }

    public void test2(){
        for (int i = 0; i < 4; i++) {
            threadLocal.set(i);
            transmittableThreadLocal.set(i);
            //executorService.execute(new Worker());
            executorService.execute(TtlRunnable.get(new Worker()));
        }
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("threadLocal: " + threadLocal.get());
            System.out.println("inheritableThreadLocal: " + transmittableThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        TransmittableThreadLocalTest threadLocalTest = new TransmittableThreadLocalTest();
        threadLocalTest.test2();
    }

}
