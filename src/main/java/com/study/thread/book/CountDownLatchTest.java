package com.study.thread.book;

import sun.awt.windows.WToolkit;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public long timeTasks(int nThread, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);
        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread(){
                public void run(){
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignore) {

                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        System.out.println("开始任务！");
        startGate.countDown();
        endGate.await();
        System.out.println("任务结束！");
        long end = System.nanoTime();
        return end-start;
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long time= new CountDownLatchTest().timeTasks(3, new Worker());
        System.out.println("花费时间:"+time);
    }
}
