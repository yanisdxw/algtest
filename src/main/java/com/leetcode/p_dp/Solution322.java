package com.leetcode.p_dp;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) return -1;
        int n = coins.length;
        //转化为完全背包问题，coin中第i个物品为v，总数j为w
        //dp表示在可以取前i个物品时，能填充完j数值的最小值
        int[][] dp = new int[n+1][amount+1];
        //初始化：dp[i][0]肯定为0,因为让总数为0只要不取硬币就行
        //其他都是-1
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount ; j++) {
                if(coins[i-1]>j){//第i个coin不能取
                    dp[i][j] = dp[i-1][j];
                }else {//第i个coin可以取
                    int v = dp[i][j-coins[i-1]]!=-1?dp[i][j-coins[i-1]]+1:-1;
                    dp[i][j] = minCoin(v, dp[i-1][j]);
                }
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[n][amount];
    }

    //辅助函数取最小值。因为有-1的存在，需要特殊判断
    //-1不能为最小值
    private int minCoin(int a, int b){
        if(a==-1&&b==-1){
            return -1;
        }else if(a==-1&&b!=-1){
            return b;
        }else if(a!=-1&&b==-1){
            return a;
        }else {
            return Math.min(a,b);
        }
    }


    public static void main(String[] args) {
        int[] coins = new int[]{2,5};
        int amounts = 9;
        int ans = new Solution322().coinChange(coins, amounts);
    }

}
