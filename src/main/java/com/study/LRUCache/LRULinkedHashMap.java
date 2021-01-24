package com.study.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K,V> implements LRUCache<K,V> {

    //加载因子，已存和的数据容量与总容量的比率
    private static final float   hashTableLoadFactor = 0.75f;
    //用LinkedHashMap作为存放元素的容器
    private LinkedHashMap<K,V> map;
    //缓存中所能保持的元素最大值
    private int cacheSize;


    public LRULinkedHashMap (int cacheSize) {
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int)Math.ceil(cacheSize / hashTableLoadFactor) + 1;
        map = new LinkedHashMap<K,V>(hashTableCapacity, hashTableLoadFactor, true) {
            private static final long serialVersionUID = 1;
            //重写removeEldestEntry方法，当元素个数大于cacheSize时淘汰旧元素
            @Override protected boolean removeEldestEntry (Map.Entry<K,V> eldest) {
                return size() > LRULinkedHashMap.this.cacheSize; }
        };
    }



    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }
}
