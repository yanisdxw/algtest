package com.leetcode.p_dp;

public class Solution279 {
    public int numSquares(int n) {
        //dp[i]表示到数字i时最少可以由多少完全平方数组成
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = i; //最多由i个数组成
            for(int j=1;j*j<=i;j++){
                //i能由几个完全平方数组成，取决于i-k*k能由几个完全平方数组成。
                //比如，7 = 3 + 2*2， 11 = 2 + 3*3；
                // 12 = 4 + 4 + 4 或 9 + 1 + 1 + 1 + 1
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
