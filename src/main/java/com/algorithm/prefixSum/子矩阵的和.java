package com.algorithm.prefixSum;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/798/
 */
public class 子矩阵的和 {
    private final static int N = 1010;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[N][N];
        int[][] s = new int[N][N];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + a[i][j];
            }
        }
        while(q-->0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1]);
        }
    }
}
