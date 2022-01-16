package com.algorithm.twoPointer;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/802/
 */
public class 数组元素的目标和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        for(int i=0;i<m;i++) b[i] = sc.nextInt();
        for(int i=0,j=m-1;i<n;i++){
            while(j>=0 && a[i]+b[j]>target) j--;
            if(a[i]+b[j]==target){
                System.out.print(i+" "+j);
                break;
            }
        }
    }
}
