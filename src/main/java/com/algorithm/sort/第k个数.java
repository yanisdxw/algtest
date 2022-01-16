package com.algorithm.sort;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/788/
 */
public class 第k个数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int res = findK(0,n-1,a,k);
        System.out.print(res);
    }

    private static void swap(int i, int j, int[] a){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition(int l, int r, int[] a){
        int q = a[l];
        int i=l-1; int j=r+1;
        while(i<j){
            while(a[++i]<q);
            while(a[--j]>q);
            if(i<j) swap(i,j,a);
        }
        return j;
    }

    private static int findK(int l, int r, int[] a, int k){
        if(l>=r){
            return a[l];
        }
        int p = partition(l,r,a);
        int sl = p-l+1;
        if(k<=sl){
            return findK(l,p,a,k);
        }else{
            return findK(p+1,r,a,k-sl);
        }
    }
}
