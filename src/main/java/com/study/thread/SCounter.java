package com.study.thread;

public class SCounter implements Counter {
    int count = 0;

    public synchronized void count(){
        try {
            System.out.println("线程:"+Thread.currentThread().getName()+" count:"+count);
            count++;
            this.notify();
            this.wait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        SCounter counter = new SCounter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
    }
}
