package com.algorithm.prefixSum;

import java.util.Scanner;

public class 前缀和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n+1];
        for(int i=1;i<=n;i++){
            s[i] = sc.nextInt() + s[i-1];
        }
        while(m-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(s[r]-s[l-1]);
        }
    }
}
