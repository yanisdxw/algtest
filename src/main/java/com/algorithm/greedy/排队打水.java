package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/915/
 */

public class 排队打水 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            t[i] = sc.nextInt();
        }
        Arrays.sort(t);
        long res =0;
        for(int i=0;i<n;i++){
            res += t[i]*(n-i-1);
        }
        System.out.print(res);
    }
}
