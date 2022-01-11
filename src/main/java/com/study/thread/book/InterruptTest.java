package com.study.thread.book;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class InterruptTest {
    class Producer extends Thread {

        private final BlockingQueue<BigInteger> queue;

        Producer(BlockingQueue<BigInteger> queue){
            this.queue = queue;
        }

        public void run(){
            try {
                BigInteger p = BigInteger.ONE;
                while (!Thread.currentThread().isInterrupted()){
                    queue.put(p=p.nextProbablePrime());
                }
            }catch (InterruptedException e){

            }
        }

        public void cancal(){ interrupt(); }
    }
}
