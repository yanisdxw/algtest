package com.leetcode.p_dp;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
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
