package com.study.thread;

import com.study.thread.sllock.Counter;

public class MyThread extends Thread {

    private Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount()<=10){
            try {
                counter.count();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
