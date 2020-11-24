package com.study.blockingqueue;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LBlockingQueue<E> implements BlockingQueue<E> {

    //基本参数与数据容器
    private final static int DEFAULT_MAX_COUNT = 10;
    private final int maxCount;
    private final ArrayDeque<E> blockingQueue;

    //锁
    private Lock lock = new ReentrantLock();
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    public LBlockingQueue() {
        this(DEFAULT_MAX_COUNT);
    }
    public LBlockingQueue(int size) {
        blockingQueue = new ArrayDeque<>(size);
        maxCount = size;
    }

    @Override
    public void put(E e) {
        try {
            lock.lock();
            try {
                while (blockingQueue.size() >= maxCount) {
                    System.out.println("队列满了，等待消费数据");
                    isFull.await();
                }
            } catch (InterruptedException ex) {
                isFull.signal();
                ex.printStackTrace();
            }
            blockingQueue.add(e);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E get() {
        try {
            lock.lock();
            try {
                while (blockingQueue.size() == 0) {
                    System.out.println("队列中暂时还没数据，等待生产数据");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            E res = blockingQueue.removeFirst();
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }


    @Override
    public int size() {
        return blockingQueue.size();
    }
}
