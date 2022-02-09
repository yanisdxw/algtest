package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/877/
 */
public class 快速幂 {

    //求 a^k mod p
    private static long qmi(long a, long k, long p){
        long res = 1L%p;
        while(k!=0){
            if((k&1)==1) res=res*a%p;
            k>>=1;
            a = a*a%p;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            long a = sc.nextLong();
            long k = sc.nextLong();
            long p = sc.nextLong();
            System.out.println(qmi(a,k,p));
        }
    }
}
