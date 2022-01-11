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

    public static void main(String[] args) throws InterruptedException {
        SCounter counter = new SCounter();
        Thread myThread1 = new Thread(new Worker(counter));
        Thread myThread2 = new Thread(new Worker(counter));
        myThread1.start();
        myThread2.start();
    }

    static class Worker implements Runnable {

        private final Counter counter;

        Worker(Counter counter){
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
}
