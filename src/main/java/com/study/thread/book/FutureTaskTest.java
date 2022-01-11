package com.study.thread.book;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new FutureTaskTest().test();
    }

    public void test() throws ExecutionException, InterruptedException {
        Task task = new Task();// 新建异步任务
        FutureTask<Integer> futureTask1 = new FutureTask<>(task);
        new Thread(futureTask1).start();
        FutureTask<Integer> futureTask2 = new FutureTask<>(task);
        new Thread(futureTask2).start();

        System.out.println("开始任务1,2！");

        Integer rst1 = futureTask1.get();
        Integer rst2 = futureTask2.get();

        System.out.println("rst1: "+rst1);
        System.out.println("rst2: "+rst2);
    }


    // 异步任务
    static class Task implements Callable<Integer> {
        // 返回异步任务的执行结果
        @Override
        public Integer call() throws Exception {
            Integer rst = (int) (Math.random()*10000);
            Thread.sleep(rst);
            return rst;
        }
    }

}
