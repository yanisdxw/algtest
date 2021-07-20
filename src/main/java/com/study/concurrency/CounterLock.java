package com.study.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock implements Runnable {

    private int a = 0;
    private ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                a++;
                System.out.println(Thread.currentThread().getName()+":"+a);
                condition.signal();
                condition.await();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        CounterLock counter = new CounterLock();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
    }

}
