package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/888/
 */
public class 求组合数II {

    private static int N = 100010;
    private static int mod = (int)1e9+7;
    private static long[] fact = new long[N];
    private static long[] infact = new long[N];

    private static int qmi(int a, int k, int p){
        int res = 1%p;
        while(k>0){
            if((k&1)==1) res = (int)(((long)res*a % p));
            a = (int)((long)a*a%p);
            k>>=1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fact[0] = infact[0] = 1;
        //c[a][b] = a!/(a-b)!b! ==> a!*(a-b)^(-1)!*b^(-1)!
        //fact[i] = i!
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i-1]*i%mod;
            infact[i] = infact[i-1]*qmi(i,mod-2,mod)%mod;
        }
        while (n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(fact[a]*infact[a-b]%mod*infact[b]%mod);
        }
    }
}
