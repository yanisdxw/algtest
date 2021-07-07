package com.leetcode.p_dp;

/**
 * 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 */
public class Solution115 {

    //以s = "babgbag", t = "bag"为例子
    //t  s "" b a b g b a g
    //""    1 1 1 1 1 1 1 1
    //b     0 1 1 2 2 3 3 3
    //a     0 0 1 1 1 1 4 4
    //g     0 0 0 0 1 1 1 5


    public int numDistinct(String s, String t) {
        //设dp[i][j]为T前i字符串可以由S前j字符串组成最多个数.
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];
        //初始化dp为0
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
//        for (int i = 0; i < t.length(); i++) {
//            dp[i][0] = 0;
//        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
                System.out.println("dp["+i+"]["+j+"]:"+dp[i][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "A0B0";
        String t = "AB";
        int ans = new Solution115().numDistinct(s,t);
        System.out.println(ans);
    }
}
