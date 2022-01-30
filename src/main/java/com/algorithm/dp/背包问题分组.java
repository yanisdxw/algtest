package com.algorithm.dp;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/9/
 */
public class 背包问题分组 {
    private static int N = 110;
    private static int[][] v = new int[N][N];
    private static int[][] w = new int[N][N];
    private static int[] s = new int[N];
    private static int n = 0;
    private static int m = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            s[i] = sc.nextInt();
            for(int j=0;j<s[i];j++){
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[N];
        for(int i=1;i<=n;i++){
            for(int j=m;j>=0;j--){
                for(int k=0;k<s[i];k++){
                    if(v[i][k]<=j){
                        dp[j] = Math.max(dp[j],dp[j-v[i][k]]+w[i][k]);
                    }
                }
            }
        }
        System.out.print(dp[m]);
    }
}
