package com.dxw.PriorityQueue.leetcode;

//import com.dxw.PriorityQueue.PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

//    private class Freq implements Comparable<Freq>{
//        public int e, freq;
//
//        public Freq(int e, int freq) {
//            this.e = e;
//            this.freq = freq;
//        }
//
//
//        @Override
//        public int compareTo(Freq another) {
//
//            if(this.freq<another.freq){
//                return 1;
//            }else if(this.freq>another.freq){
//                return -1;
//            }else {
//                return 0;
//            }
//        }
//    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        //通过匿名类改变比较大小的规则
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a)-map.get(b);
//            }
//        });
        //lambda表达式
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );
        for(int key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
