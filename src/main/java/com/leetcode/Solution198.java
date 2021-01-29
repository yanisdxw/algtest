package com.leetcode;

import java.util.Arrays;

public class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[1] = nums[0];
        //dp[i] 代表进行到第i个房屋时最大收益。
        //有2种选择，拿第i个（此时i-1肯定不拿）或者不拿第i个
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[n];
    }
}
