package com.algorithm.dp;

import java.util.Scanner;

public class 背包问题完全 {

    private static int N = 1010;
    private static int V = 1010;

    private static int[] v = new int[N];
    private static int[] w = new int[V];

    private static int n = 0;
    private static int m = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] dp = new int[N][V];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=v[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-v[i]]+w[i]);
                }
            }
        }
        System.out.print(dp[n][m]);
    }

    //一维写法
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        for(int i=1;i<=n;i++){
//            v[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//        }
//        int[] dp = new int[V];
//        for(int i=1;i<=n;i++){
//            for(int j=0;j<=m;j++){
//                dp[j] = dp[j];
//                if(j>=v[i]){
//                    dp[j] = Math.max(dp[j], dp[j-v[i]]+w[i]);
//                }
//            }
//        }
//        System.out.print(dp[m]);
//    }

}
