package com.leetcode.p_dp;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 */
public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //设dp[i][j]为到达(i,j)的路径数量
        //当ob[i][j]==1时，dp[i][j]==0//不可达
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(obstacleGrid[i-1][j-1]==1){
                    dp[i][j]=0;
                }else {
                    if(i==1 && j==1){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
