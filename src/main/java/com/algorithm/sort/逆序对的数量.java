package com.algorithm.sort;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/790/
 */
public class 逆序对的数量 {

    private static final int N = 100010;
    private static long res = 0;
    private static int[] tmp = new int[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        mergeSort(0,n-1,a);
        System.out.print(res);
    }

    public static void mergeSort(int l, int r, int[] a){
        if(l>=r){
            return;
        }
        int mid = l+r>>>1;
        mergeSort(l,mid,a);
        mergeSort(mid+1,r,a);
        int i=l; int j=mid+1; int k=0;
        while(i<=mid && j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
                res += mid - i + 1;
            }
        }
        while(i<=mid) tmp[k++] = a[i++];
        while(j<=r) tmp[k++] = a[j++];
        for(i=l,k=0;i<=r;i++,k++) a[i] = tmp[k];
    }

}
