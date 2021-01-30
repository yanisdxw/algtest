package com.leetcode;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        //设dp[i]为以i结尾的序列最长递增序列长度
        int[] dp = new int[n+1];
        int max_len = 0;
        Arrays.fill(dp,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                //在i之前的数字j如果比i小，说明可以在nums[j]的基础上+1
                if(nums[i-1]>nums[j-1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }
}
