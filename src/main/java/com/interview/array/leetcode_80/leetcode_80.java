package com.interview.array.leetcode_80;

public class leetcode_80 {
    public int removeDuplicates(int[] nums) {

        if(nums==null||nums.length==0) return 0;

        if(nums.length==1){
            return 1;
        }

        int count = 0;
        int l = 0, r = 1;
        for (; r < nums.length; r++) {
            if(nums[r]==nums[l] && count<1){
                count++;
                l++;
            }else if(nums[r]!=nums[r-1]){
                count=0;
                l++;
            }
            nums[l] = nums[r];
        }

        return l+1;
    }
}
