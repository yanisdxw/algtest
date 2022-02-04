package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/902/
 */
public class 计数类问题整数划分 {
    private static int N = 1010;
    private static int M = (int) 1e9+7;
    private static int[] dp = new int[N];
    private static int n = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                dp[j] = (dp[j] + dp[j-i])%M;
            }
        }
        System.out.print(dp[n]);
    }
}
