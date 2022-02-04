package com.algorithm.dp;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/900/
 */
public class 线性问题数字三角形 {

    private static int N = 510;
    private static int[][] w = new int[N][N];
    private static int[][] f = new int[N][N];
    private static int n = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                w[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            f[n][i] = w[n][i];
        }
        for(int i=n-1;i>0;i--){
            for(int j=1;j<=n;j++){
                f[i][j] = Math.max(f[i+1][j],f[i+1][j+1]) + w[i][j];
            }
        }
        System.out.print(f[1][1]);
    }
}
