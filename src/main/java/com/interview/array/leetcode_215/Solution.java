package com.interview.array.leetcode_215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue q = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if(q.size()>k){
                q.poll();
            }
        }

        return (int)q.poll();
    }
}
