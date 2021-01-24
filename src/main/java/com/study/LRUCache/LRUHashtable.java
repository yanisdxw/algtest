package com.study.LRUCache;

import java.util.Hashtable;

/**
 * hashtable + 双链表实现
 * @param <K>
 * @param <V>
 */
public class LRUHashtable<K,V> implements LRUCache<K,V> {

    private int cacheSize;
    private Hashtable<Object, Entry> nodes;//缓存容器
    private int currentSize;
    private Entry first;//链表头
    private Entry last;//链表尾


    public LRUHashtable(int cacheSize) {
        this.currentSize = 0;
        this.cacheSize = cacheSize;
        this.nodes = new Hashtable<Object, Entry>(cacheSize);//缓存容器
    }


    /**
     * 将entry删除, 注意：删除操作只有在cache满了才会被执行
     */
    public void remove(K key) {
        Entry node = nodes.get(key);
        //在链表中删除
        if (node != null) {
            //将该节点从中间取出
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            //如果该节点恰好是尾结点，需要指定一个新的尾结点
            if (last == node)
                last = node.prev;
            //如果该节点恰好是头结点，需要指定一个新的头结点
            if (first == node)
                first = node.next;
        }
        //在hashtable中删除
        nodes.remove(key);
    }


    /**
     * 移动到链表头，表示这个节点是最新使用过的
     */
    private void moveToHead(Entry node) {
        if (node == first)
            return;
        //将该节点从中间取出
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        //如果该节点恰好是尾结点，需要指定一个新的尾结点
        if (last == node)
            last = node.prev;
        //把该节点插入到头结点前
        if (first != null) {
            node.next = first;
            first.prev = node;
        }
        //该节点就是头结点了
        first = node;
        node.prev = null;
        //只有一个节点的情况
        if (last == null)
            last = first;
    }

    /**
     * 删除链表尾部节点，即使用最后 使用的entry
     */
    private void removeLast() {
        //链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）
        if (last != null) {
            if (last.prev != null)
                last.prev.next = null;
            else
                first = null;
            last = last.prev;
        }
    }


    @Override
    public V get(K key) {
        Entry node = nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return null;
        }

    }

    @Override
    public void put(K key, V value) {
        //先查看hashtable是否存在该entry, 如果存在，则只更新其value
        Entry node = nodes.get(key);
        if (node == null) {
            //缓存容器是否已经超过大小.
            if (currentSize >= cacheSize) {
                nodes.remove(last.key);
                removeLast();
            } else {
                currentSize++;
            }
            node = new Entry();
        }
        node.value = value;
        //将最新使用的节点放到链表头，表示最新使用的.
        moveToHead(node);
        nodes.put(key, node);
    }

    class Entry {
        Entry prev;//前一节点
        Entry next;//后一节点
        V value;//值
        K key;//键
    }
}
