package com.project.threadlocaltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InheritableThreadLocalTest {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void test1(){
        threadLocal.set(1);
        inheritableThreadLocal.set(1);
        Thread t = new Thread(new Worker());
        t.start();
    }

    public void test2(){
        for (int i = 0; i < 4; i++) {
            threadLocal.set(i);
            inheritableThreadLocal.set(i);
            executorService.execute(new Worker());
        }
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("threadLocal: " + threadLocal.get());
            System.out.println("inheritableThreadLocal: " + inheritableThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        InheritableThreadLocalTest threadLocalTest = new InheritableThreadLocalTest();
        threadLocalTest.test2();
    }
}
