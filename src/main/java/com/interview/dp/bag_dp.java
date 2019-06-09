package com.interview.dp;

import java.util.Arrays;

public class bag_dp {

    public int knapstack01(int[] w, int[] v, int C){
        int n = w.length;

        if(n==0){
            return 0;
        }

        int[][] dp = new int[n][C+1];
        Arrays.fill(dp,-1);
        for (int j = 0; j <= C; j++) {
            dp[0][j] = (j>=w[0]?v[0]:0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=C ; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=w[i]){
                    dp[i][j] = Math.max(dp[i][j], v[i]+dp[i-1][j-w[i]]);
                }
            }
        }
        return dp[n-1][C];
    }
}
