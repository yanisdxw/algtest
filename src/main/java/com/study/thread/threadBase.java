package com.study.thread;

public class threadBase {

    public static void main(String[] args) {
        LCounter counter = new LCounter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
    }
}
