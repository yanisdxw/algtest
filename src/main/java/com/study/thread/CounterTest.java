package com.study.thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CounterTest {

    static class Counter {
        private int count;

        Counter(int count){
            this.count = count;
        }

        public int get(){
            return count;
        }

        public void add(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestLCounterWorker();
    }

    @SneakyThrows
    public static void TestSCounterWorker(){
        Counter counter = new Counter(0);
        Thread t1 = new Thread(new SCounterWorker(counter));
        Thread t2 = new Thread(new SCounterWorker(counter));
        t1.start();
        t2.start();
        Thread.sleep(10);
        t1.interrupt();
        t2.interrupt();
    }

    @SneakyThrows
    public static void TestLCounterWorker(){
        final Counter counter = new Counter(0);
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    lock.lock();
                    try {
                        while (counter.get()%2==0){
                            condition.await();
                        }
                        System.out.println("线程:"+Thread.currentThread().getName()+" count:"+counter.get());
                        counter.add();
                        condition.signalAll();
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    lock.lock();
                    try {
                        while (counter.get()%2!=0){
                            condition.await();
                        }
                        System.out.println("线程:"+Thread.currentThread().getName()+" count:"+counter.get());
                        counter.add();
                        condition.signalAll();
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(10);
        t1.interrupt();
        t2.interrupt();
    }

    static class SCounterWorker implements Runnable{

        private final Counter counter;

        SCounterWorker(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                   synchronized (counter){
                        System.out.println("线程:"+Thread.currentThread().getName()+" count:"+counter.get());
                        counter.add();
                        counter.notifyAll();
                        counter.wait();
                    }
                }catch (Exception e){

                }
            }
        }
    }
}
