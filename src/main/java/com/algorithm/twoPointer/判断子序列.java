package com.algorithm.twoPointer;

import java.util.Scanner;

public class 判断子序列 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        String res = "No";
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        for(int i=0;i<m;i++) b[i] = sc.nextInt();
        for(int i=0,j=0;j<m;j++){
            if(a[i]==b[j]) i++;
            if(i==n) {
                res = "Yes";
                break;
            }
        }
        System.out.print(res);
    }
}
