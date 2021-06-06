package com.leetcode.p_dp;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution62 {

    /** dfs会超时
    private int total;
    public int uniquePaths(int m, int n) {
        total = 0;
        dfs(1,1,m,n);
        return total;
    }

    private void dfs(int x, int y, int m, int n){
        if(x==m && y==n){
            total++;
            return;
        }
        if(x>m || y>n){
            return;
        }
        dfs(x+1,y,m,n);
        dfs(x,y+1,m,n);
    }
     */

    public int uniquePaths(int m, int n) {
        //dp表示走到m,n这个位置上有几种方法
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //dp[1][1] = dp[0][1] + dp[1][0]
                if(i==1 && j==1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int ans = new Solution62().uniquePaths(1,1);
        System.out.println(ans);
    }
}
