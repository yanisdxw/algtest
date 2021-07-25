package com.study.concurrency;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentContainerDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        System.out.println(threadLocal.get());
    }
}
