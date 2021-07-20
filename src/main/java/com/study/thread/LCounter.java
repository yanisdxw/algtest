package com.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LCounter implements Counter {

    int count = 0;

    //锁
    private Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void count() {
        try {
            lock.lock();
            System.out.println("线程:"+Thread.currentThread().getName()+" count:"+count);
            count++;
            condition.signal();
            condition.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        LCounter counter = new LCounter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
    }
}
