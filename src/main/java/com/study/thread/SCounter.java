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
}
