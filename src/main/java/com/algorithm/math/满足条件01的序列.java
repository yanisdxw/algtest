package com.algorithm.math;

import java.util.Scanner;

public class 满足条件01的序列 {
    private static int N = 100010;
    private static final int mod = (int) 1e9+7;

    private static long qmi(int a, int k, int p){
        long res=1;
        while(k>0){
            if((k&1)!=0) res = res*a%p;
            a = a*a%p;
            k>>=1;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 2*n; int b = n;
        long res = 1;
        for(int i=a;i>=a-b;i--){
            res = res*i%mod;
        }
        for(int i=1;i<=b;i++){
            res = res*qmi(i,mod-2,mod);
        }
        res = res*qmi(n+1,mod-2,mod);
        System.out.print(res);
    }
}
