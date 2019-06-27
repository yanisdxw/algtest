package com.interview.others.stocks;

public class leetcode_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length; i++) {
            if(minPrice>=prices[i]){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfile){
                maxProfile = prices[i] - minPrice;
            }
        }
        return maxProfile;
    }
}
