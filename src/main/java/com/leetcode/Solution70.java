package com.leetcode;

import java.util.Arrays;

public class Solution70 {

    public int climbStairs(int n) {
        if(n<2) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        //dp[i]代表到第i层台阶有几种走法
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = new Solution70().climbStairs(3);
        System.out.println(ans);
    }
}
