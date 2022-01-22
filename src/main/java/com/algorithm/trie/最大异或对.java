package com.algorithm.trie;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/145/
 */
public class 最大异或对 {

    private static int N = 100010;
    private static int M = 3100010;
    private static int[][] son = new int[M][2];
    private static int[] a = new int[N];
    private static int idx = 0;

    private static void insert(int x){
        int p =0;
        for(int i=30;i>=0;i--){
            int s = x>>>i&1;
            if(son[p][s]==0) son[p][s] = ++ idx;
            p = son[p][s];
        }
    }

    private static int query(int x){
        int p=0; int res = 0;
        for(int i=30;i>=0;i--){
            int s = x>>>i&1;
            int ss = s==0?1:0;
            if(son[p][ss]!=0){
                res += 1<<i;
                p = son[p][ss];
            }else{
                p = son[p][s];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            insert(a[i]);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res, query(a[i]));
        }
        System.out.print(res);
    }
}
