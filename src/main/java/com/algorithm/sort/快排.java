package com.algorithm.sort;

import com.leetcode.Utils;

import java.util.Scanner;

public class 快排 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
//        quickSort(0,n-1,a);
        int p = partition(0,n-1,a);
        System.out.println(p);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
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

    private static void quickSort(int l, int r, int[] a){
        if(l>=r) return;
        int p = partition(l,r,a);
        quickSort(l,p,a);
        quickSort(p+1,r,a);
    }

    private static void swap(int i, int j, int[] a){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
