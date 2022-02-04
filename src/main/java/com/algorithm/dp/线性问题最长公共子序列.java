package com.algorithm.dp;

import com.leetcode.Utils;

import java.util.Scanner;

public class 线性问题最长公共子序列 {
    private static int N = 1010;
    private static int[][] f = new int[N][N];
    private static char[] a = new char[N];
    private static char[] b = new char[N];
    private static int m = 0;
    private static int n = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String sa = sc.next();
        for(int i=0;i<sa.length();i++){
            a[i+1] = sa.charAt(i);
        }
        String sb = sc.next();
        for(int i=0;i<sb.length();i++){
            b[i+1] = sb.charAt(i);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j] = Math.max(f[i][j-1],f[i-1][j]);
                if(a[i]==b[j]){
                    f[i][j] = Math.max(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        System.out.print(f[n][m]);
    }
}
