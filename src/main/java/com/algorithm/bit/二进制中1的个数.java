package com.algorithm.bit;

import java.util.Scanner;

public class 二进制中1的个数 {

    public static int lowbit(int x){
        return x&-x; // x&(~x+1)
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int x = a[i];
            int res=0;
            while(x>0){
                x -= lowbit(x);
                res++;
            }
            System.out.print(res+" ");
        }

    }
}
