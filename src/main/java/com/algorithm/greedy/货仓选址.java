package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/106/
 */
public class 货仓选址 {
    //绝对值不等式
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int res =0;
        for(int i=0;i<n;i++){
            res += Math.abs(a[i]-a[n/2]);
        }
        System.out.print(res);
    }
}
