package com.study.thread.book;

import java.util.Vector;

public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x){
        boolean absent = ! contains(x);
        if(absent){
            add(x);
        }
        return absent;
    }
}
