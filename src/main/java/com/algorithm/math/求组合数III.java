package com.algorithm.math;

import java.util.Scanner;

public class 求组合数III {

    private static int p;

    private static long qmi(long a, long k, long p){
        long res = 1L;
        while (k>0){
            if((k&1)!=0) res = res*a%p;
            a = a*a%p;
            k>>=1;
        }
        return res;
    }

    private static long C(long a, long b, long p){
        if(a<b) return 0;
        long res = 1L;
        for (long i = 1, j = a; i <= b; i++,j--) {
            res = res*j%p;
            res = res*i*qmi(i,p-2,p)%p;
        }
        return res;
    }

    private static long lucas(long a, long b, long p){
        if(a<p && b<p) return C(a,b,p);
        return C(a%p, b%p,p)*lucas(a/p,b/p,p)%p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long p = sc.nextInt();
            System.out.println(lucas(a,b,p));
        }
    }
}
