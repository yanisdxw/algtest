package com.interview.dp.leetcode_64;

import java.util.Arrays;

public class leetcode_64 {
//    public int integerBreak(int n) {
//        return breakInteger(n);
//    }
//
//    //将n进行分割 至少两部分 可以获得最大的乘积
//    private int breakInteger(int n){
//        if(n==1){
//            return 1;
//        }
//        int res = -1;
//        for (int i = 0; i <= n-i ; i++) {
//            res = Math.max(res, Math.max(i*(n-i),i*breakInteger(n-i)));
//        }
//        return res;
//    }
        public int integerBreak(int n) {
            //dp[i]表示将数字i分割后（两部分）得到的最大乘积
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            dp[1] = 1;
            for (int i = 2; i <=n ; i++) {
                //求解dp[i]
                for (int j = 0; j <=i-1 ; j++) {
                    // j + (i-j)
                    dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                }
            }
            return dp[n];
        }
}
