package com.leetcode.p_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-(k-1)];
        //利用deque实现一个近似的单调队列
        //最左边是最大值，依次递减
        for (int i = 0; i < n; i++) {
            //队列最大值的日期等于[滑动窗]的左边界时i-k，将其移除队列
            if(!deque.isEmpty()&&deque.getFirst()==i-k){
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i-(k-1)>=0){
                ans[i-k+1] = nums[deque.getFirst()];
            }
        }
        return ans;
    }
}
