package com.leetcode;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        //天数小于操作数的一半，相当于无限次操作，直接贪心
        if(prices.length<k/2){
            return greedy(prices);
        }
        int n = prices.length;
        //设2个数组：成本buy[i]与利润sell[i]
        //分别表示前i天第j次交易所获取的最小成本与最大利润
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k+1];
        Arrays.fill(sell, 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j],prices[i-1]-sell[j-1]);
                sell[j] = Math.max(sell[j],prices[i-1]-buy[j]);
            }
        }
        return sell[k];
    }


    public int greedy(int[] prices) {
        int maxProfile = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                maxProfile += prices[i] - prices[i-1];
            }
        }
        return maxProfile;
    }
}
