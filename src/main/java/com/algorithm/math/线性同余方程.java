package com.algorithm.math;

import java.util.Scanner;

/**
 * 线性同余方程
 */
public class 线性同余方程 {

    private static long exgcd(long a, long b, long[] x, long[] y){
        if(b==0){
            x[0] = 1; y[0] = 0;
            return a;
        }
        long d = exgcd(b,a%b,y,x);
        y[0]-=a/b*x[0];
        return d;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){

            long a = sc.nextInt();
            long b = sc.nextInt();
            long m = sc.nextInt();

            long[] x = new long[1];
            long[] y = new long[1];
            long d = exgcd(a,m,x,y);
            if(b%d!=0) {
                System.out.println("impossible");
            } else {
                System.out.println(b/d*x[0]%m);
            }
        }
    }
}
