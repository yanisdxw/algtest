package com.algorithm.dp;

import java.util.Scanner;

public class 背包问题多重I {
    private static int N = 110;
    private static int n = 0;
    private static int m = 0;
    private static int v[] = new int[N];
    private static int w[] = new int[N];
    private static int s[] = new int[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int[][] dp = new int[N][N];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=s[i]&&j>=k*v[i];k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*v[i]]+k*w[i]);
                }
            }
        }
        System.out.print(dp[n][m]);
    }

//   一维写法
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        for(int i=1;i<=n;i++){
//            v[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//            s[i] = sc.nextInt();
//        }
//        int[] dp = new int[N];
//        for(int i=1;i<=n;i++){
//            for(int j=m;j>=v[i];j--){
//                for(int k=0;k<=s[i]&&j>=k*v[i];k++){
//                    dp[j] = Math.max(dp[j], dp[j-k*v[i]]+k*w[i]);
//                }
//            }
//        }
//        System.out.print(dp[m]);
//    }
}
