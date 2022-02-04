package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/897/
 */
public class 线性问题最长上升子序列 {

    private static int N = 1010;
    private static int[] a = new int[N];
    private static int[] f = new int[N];
    private static int n = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.fill(f,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[i]>a[j]){
                    f[i] = Math.max(f[j]+1, f[i]);
                }
            }
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            res = Math.max(res, f[i]);
        }
        System.out.print(res);
    }
}
