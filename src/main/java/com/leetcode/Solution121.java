package com.leetcode;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp表示在前i天中的任意一天买，第i天卖的股票收益
        //sell表示前i天最低买入价
        int sell = Integer.MAX_VALUE;
        int max = 0;
        for(int i=2;i<=n;i++){
            sell = Math.min(sell, prices[i-2]);
            max = Math.max(max, prices[i-1] - sell) ;
        }
        return max;
    }
}
