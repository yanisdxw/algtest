package com.algorithm.dp;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/284/
 */
public class 区间问题石子合并 {
    private static int N = 310;
    private static int n = 0;
    private static int[][] f = new int[N][N];
    private static int[] s = new int[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            s[i] = sc.nextInt();
            s[i] += s[i-1];
        }
        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int l = i; int r = i+len-1;
                f[l][r] = (int) 1e8;
                for(int k=l;k<r;k++){
                    f[l][r] = Math.min(f[l][r],f[l][k]+f[k+1][r]+s[r]-s[l-1]);
                }
            }
        }
        System.out.print(f[1][n]);
    }
}
