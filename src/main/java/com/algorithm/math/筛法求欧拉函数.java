package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/876/
 */

public class 筛法求欧拉函数 {
    private static int N = 1000010;
    private static boolean[] st = new boolean[N];
    private static int[] primes = new int[N];
    private static int[] phi = new int[N];

    private static int euler(int n){
        phi[1] = 1; int cnt = 0;
        for (int i = 2; i<=n ; i++) {
            if(!st[i]) {
                primes[cnt++]=i;
                phi[i] = i-1;
            }
            for (int j = 0; primes[j]<=n/i; j++) {
                st[primes[j]*i] = true;//用最小质因子去筛合数
                if(i%primes[j]==0) {
                    phi[primes[j]*i] = primes[j]*phi[i];
                    break;
                }
                phi[primes[j]*i] = (primes[j]-1)*phi[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        euler(n);
        long res= 0;
        for(int i=1;i<=n;i++){
            res += phi[i];
        }
        System.out.print(res);
    }
}
