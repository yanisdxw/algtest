package com.study.LRUCache;

public interface LRUCache<K,V> {
    V get(K key);
    void put(K key, V value);
}
