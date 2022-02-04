package com.algorithm.dp;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/898/
 */

public class 线性问题最长上升子序列II {
    private static int N = 100010;
    private static int[] q = new int[N];
    private static int[] a = new int[N];
    private static int n = 0;
    private static int len = 0;


    private static int lbsearch(int t){
        int l = 1; int r = len;
        while(l<r){
            int mid = r+l>>1;
            if(q[mid]>=t){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        q[++len] = a[1];
        for(int i=2;i<=n;i++){
            if(a[i]>q[len]){
                q[++len] = a[i];
            }else{
                int tmp = lbsearch(a[i]);
                q[tmp] = a[i];
            }
        }
        System.out.print(len);
    }
}
