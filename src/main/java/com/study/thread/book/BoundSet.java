package com.study.thread.book;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded){
                semaphore.release();
            }
        }
    }

    public boolean remove(Object o){
        boolean wasRemoved = set.remove(o);
        if(wasRemoved){
            semaphore.release();
        }
        return wasRemoved;
    }

    public static void main(String[] args) throws InterruptedException {
        BoundSet<Integer> boundSet = new BoundSet<>(10);
        for (int i = 0; i < 11; i++) {
            boundSet.add(i);
            System.out.println("add "+i);
        }
        System.out.println("finished!");
    }
}
