package com.interview.stack.leetcode_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_279 {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.poll();
            int num = front.getKey();
            int step = front.getValue();

            for(int i = 1 ; ; i ++){
                int a = num - i*i;
                if(num < i*i){
                    break;
                }
                if(a==0){
                    return step + 1;
                }
                if(!visited[num - i * i]){
                    queue.offer(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }

            printQueuePair(queue);
        }

        throw new IllegalStateException("No Solution.");
    }

    public void printQueuePair(LinkedList<Pair<Integer, Integer>> q){
        for(Pair<Integer,Integer> p:q){
            System.out.print("<"+p.key+","+p.value+">");
            System.out.print(" ");
        }
        System.out.println();
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

    public static void main(String[] args) {
        leetcode_279 leetcode_279 = new leetcode_279();
        int res = leetcode_279.numSquares(12);
        System.out.println(res);
    }
}
