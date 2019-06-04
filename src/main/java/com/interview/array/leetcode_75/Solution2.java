package com.interview.array.leetcode_75;

import com.interview.array.Util;

public class Solution2 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if(nums[i]==1){
                i++;
            }else if(nums[i]==2){
                swap(nums,i,--two);
            }else {
                assert (nums[i]==0);
                swap(nums,++zero,i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

    }
}
