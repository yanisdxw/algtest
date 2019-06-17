package com.interview.find.leetcode_16;

import java.util.Arrays;

public class leetcode_16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }

                if(Math.abs(sum - target)<Math.abs(result - target)){
                    result = sum;
                }

            }
        }
        return result;
    }
}
