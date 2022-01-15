package com.study.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class CompleteServiceDemo {
    @SneakyThrows
    public static void main(String[] args) {
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(3));
        for (int i = 0; i < 3; i++) {
            completionService.submit(new Task(1,2));
        }
        for (int i = 0; i < 3; i++) {
            Future<Integer> future = completionService.take();
            System.out.println(future.get());
        }
    }

    static class Task implements Callable<Integer> {

        private int a;
        private int b;
        public Task(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return this.a + this.b;
        }
    }
}
