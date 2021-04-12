package com.leetcode.p_priorityqueue;

import java.util.*;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class Solution264 {
    int [] nums = new int[]{2,3,5};
    public int nthUglyNumber(int n) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        priorityQueue.add(1);
        set.add(1);
        for (int i = 0; i <= n; i++) {
            int min = priorityQueue.poll();
            if(i==n) return min;
            for(int num :nums){
                int next = min*num;
                if(!set.contains(next)){
                    set.add(next);
                    priorityQueue.add(next);
                }
            }
        }
        return -1;
    }
}
