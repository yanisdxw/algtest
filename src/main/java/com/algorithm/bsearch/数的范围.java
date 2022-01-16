package com.algorithm.bsearch;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/791/
 */
public class 数的范围 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[q];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<q;i++){
            b[i] = sc.nextInt();
        }
        for(int i=0;i<q;i++){
            bsearch(a,b,i);
        }
    }

    private static void bsearch(int[] a, int[] b, int i){
        int l=0; int r=a.length-1;
        while(l<r){
            int mid = l+r>>>1;
            //先找左边界
            if(a[mid]>=b[i]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(a[l]!=b[i]) {
            System.out.print("-1 -1");
        }else{
            System.out.print(l);
            l=0; r=a.length-1;
            while(l<r){
                int mid = l+r+1>>>1;
                //再找右边界
                if(a[mid]<=b[i]){
                    l=mid;
                }else{
                    r=mid-1;
                }
            }
            System.out.print(" "+l);
        }
        System.out.println();
    }
}
