package com.leetcode.p_dp;

import java.util.Arrays;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int m = grid.length;
        if(grid[0].length==0){
            return 0;
        }
        int n = grid[0].length;
        //设dp[i][j]为走到(i,j)要花的最短路径
        int[][]dp = new int[m+1][n+1];
        for (int[] row: dp){
            Arrays.fill(row, 0);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else if(i==0&&j!=0){
                    dp[i][j] = grid[i][j]+dp[i][j-1];
                }else if(i!=0&&j==0){
                    dp[i][j] = grid[i][j]+dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        int ans = new Solution64().minPathSum(grid);
        System.out.println(ans);
    }
}
