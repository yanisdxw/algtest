package com.interview.find.leetcode_219;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1)
            return false;

        if(k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length; i ++){
            if(record.contains(nums[i]))
                return true;

            record.add(nums[i]);
            if(record.size() == k + 1)
                record.remove(nums[i-k]);
        }

        return false;
    }
}
