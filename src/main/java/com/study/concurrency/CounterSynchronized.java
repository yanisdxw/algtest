package com.study.concurrency;

public class CounterSynchronized implements Runnable {

    private Integer a = 0;

    @Override
    public synchronized void run() {
        while (true){
            try {
                a++;
                System.out.println(Thread.currentThread().getName()+":"+a);
                Thread.sleep(100);
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CounterSynchronized counter = new CounterSynchronized();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
    }
}
