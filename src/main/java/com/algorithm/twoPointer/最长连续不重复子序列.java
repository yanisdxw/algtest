package com.algorithm.twoPointer;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2818/
 */
public class 最长连续不重复子序列 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[] s = new int[10000];
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0,j=0;i<n;i++){
            s[a[i]]++;
            while(j<=i && s[a[i]]>1){
                s[a[j]]--;
                j++;
            }
            res = Math.max(res, i-j+1);
        }
        System.out.print(res);
    }
}
