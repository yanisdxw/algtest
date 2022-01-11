package com.study.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new FutureDemo().demo();
    }

    public void demo() throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<100;i++)
            results.add(es.submit(new Task()));

        for(Future<String> res : results)
            System.out.println(res.get());
    }

    class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }

}
