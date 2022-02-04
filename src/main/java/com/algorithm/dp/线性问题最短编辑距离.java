package com.algorithm.dp;

import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/904/
 */
public class 线性问题最短编辑距离 {
    private static int N = 1010;
    private static int[] a = new int[N];
    private static int[] b = new int[N];
    private static int n = 0;
    private static int m = 0;
    private static int[][] f = new int[N][N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String sa = sc.next();
        for(int i=1;i<=sa.length();i++){
            a[i] = sa.charAt(i-1);
        }
        m = sc.nextInt();
        String sb = sc.next();
        for(int i=1;i<=sb.length();i++){
            b[i] = sb.charAt(i-1);
        }
        for(int i=1;i<=n;i++){
            f[i][0] = i;
        }
        for(int i=1;i<=m;i++){
            f[0][i] = i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j] = Math.min(f[i-1][j]+1,f[i][j-1]+1);
                if(a[i]==b[j]){
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                }else{
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        System.out.print(f[n][m]);
    }
}
