package com.study.thread.book;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public long timeTasks(int nThread, final Runnable task) throws InterruptedException {
        final CyclicBarrier cb = new CyclicBarrier(nThread);
        long start = System.nanoTime();
        System.out.println("开始任务！");
        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread(){
                public void run(){
                    try {
                        Thread.sleep((long) Math.random()*10000);
                        System.out.println("准备任务！");
                        cb.await();
                        task.run();
                        cb.await();
                        System.out.println("完成任务！");
                    } catch (Exception ignore) {

                    }
                }
            };
            t.start();
        }
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

    public static void main(String[] args) throws Exception {
        long time= new CyclicBarrierTest().timeTasks(3, new CyclicBarrierTest.Worker());
        System.out.println("花费时间:"+time);
    }
}
