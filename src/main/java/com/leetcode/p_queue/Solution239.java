package com.leetcode.p_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
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
