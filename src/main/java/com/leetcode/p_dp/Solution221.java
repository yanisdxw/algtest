package com.leetcode.p_dp;

import java.util.Arrays;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        //这里设dp[i][j]为以(i,j)为左下角的长方形最大面积
        //dp[i][j]要构成正方形，首先matrix[i][j]!=0
        //其次dp[i][j]的面积最大取决于dp[i-1][j],dp[i][j-1],dp[i-1][j-1]的最小值;
        if(matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        if(matrix[0].length==0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        int max_size = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                //这里要求的是过程中的最大结果
                max_size = Math.max(max_size, dp[i][j]*dp[i][j]);
            }
        }
        return max_size;
    }
}
