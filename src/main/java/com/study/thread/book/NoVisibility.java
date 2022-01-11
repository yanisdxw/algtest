package com.study.thread.book;

public class NoVisibility extends Thread {
    private static int number;
    private static boolean ready;
    private int count;

    private NoVisibility(int count){
        this.count = count;
    }

    @Override
    public void run() {
        while (!ready){
            Thread.yield();
            System.out.println("第"+count+"次:"+number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            number = 0;
            ready = false;
            NoVisibility noVisibility = new NoVisibility(i);
            noVisibility.start();
            number = 42;
            Thread.sleep(1);
            ready = true;
        }
    }
}
