package com.leetcode.p_dp;

import java.util.Arrays;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
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
