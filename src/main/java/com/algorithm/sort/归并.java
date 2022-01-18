package com.algorithm.sort;

import java.util.Scanner;

public class 归并 {
    public static final int N = 100010;
    public static int[] tmp = new int[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        mergeSort(0,n-1,a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void mergeSort(int l, int r, int[] a){
        if(l>=r) return;
        int mid=(l+r)>>>1;
        mergeSort(l,mid,a);
        mergeSort(mid+1,r,a);
        int k=0;
        int i=l; int j=mid+1;
        while(i<=mid && j<=r){
            if(a[i]>=a[j]){
                tmp[k++] = a[j++];
            }else{
                tmp[k++] = a[i++];
            }
        }
        while(i<=mid){
            tmp[k++] = a[i++];
        }
        while(j<=r){
            tmp[k++] = a[j++];
        }
        for(i=l,k=0;i<=r;i++){
            a[i] = tmp[k++];
        }
    }
}
