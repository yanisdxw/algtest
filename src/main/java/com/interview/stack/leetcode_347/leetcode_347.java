package com.interview.stack.leetcode_347;

import java.util.*;

public class leetcode_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new PairComparator());
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        //维护优先队列处理前K个元素
        for(Integer i:map.keySet()){
            //该元素的频率
            int freq = map.get(i);
            if(pq.size()==k){
                if(freq>pq.peek().getKey()){
                    pq.poll();
                    pq.offer(new Pair<>(freq,i));
                }
            }else {
                pq.offer(new Pair<>(freq,i));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll().value);
        }
        return res;
    }

    class Pair<K,V>{

        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue(){
            return value;
        }

    }

    private class PairComparator implements Comparator<Pair<Integer, Integer>>{

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }
}
