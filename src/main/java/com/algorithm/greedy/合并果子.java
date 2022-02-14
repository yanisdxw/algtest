package com.algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/150/
 */
public class 合并果子 {
    //哈夫曼算法
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            heap.add(x);
        }
        int res = 0;
        while(heap.size()>1){
            int a = heap.poll();
            int b = heap.poll();
            res += a+b;
            heap.add(a+b);
        }
        System.out.print(res);
    }
}
