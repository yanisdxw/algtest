package com.study.concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class CompleteFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new CompleteFutureDemo().demo();
    }

    public void demo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFutureOne = new CompletableFuture<>();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Task(completableFutureOne));

        // WhenComplete 方法返回的 CompletableFuture 仍然是原来的 CompletableFuture 计算结果.
        CompletableFuture<String> completableFutureTwo = completableFutureOne.whenComplete((s, throwable) -> {
            System.out.println("当异步任务执行完毕时打印异步任务的执行结果: " + s);
        });
        // ThenApply 方法返回的是一个新的 completeFuture.
        CompletableFuture<Integer> completableFutureThree = completableFutureOne.thenApply(s -> {
            System.out.println("当异步任务执行结束时, 根据上一次的异步任务结果, 继续开始一个新的异步任务!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.length();
        });
        System.out.println("task 2 "+completableFutureTwo.get());
        System.out.println("task 3 "+completableFutureThree.get());
        System.out.println("complete!");
        es.shutdown();
    }

    class Task implements Callable<String> {

        private CompletableFuture<String> completableFuture;

        public Task(CompletableFuture<String> completableFuture){
            this.completableFuture = completableFuture;
        }

        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            Thread.sleep((long) Math.random()*10000);
            System.out.printf("Thread#%s : in call\n", tid);
            completableFuture.complete(tid);
            return tid;
        }
    }
}
