package com.algorithm.math;

import java.util.Scanner;

public class 筛质数线性筛 {
    private static int N = 1000010;
    private static boolean[] st = new boolean[N];
    private static int[] primes = new int[N];

    private static int getPrime(int n){
        int cnt = 0;
        for (int i = 2; i<=n ; i++) {
            if(!st[i]) primes[cnt++]=i;
            for (int j = 0; primes[j]<=n/i; j++) {
                st[primes[j]*i] = true;//用最小质因子去筛合数

                //1)当i%primes[j]!=0时,说明此时遍历到的primes[j]不是i的质因子，那么只可能是此时的primes[j]<i的
                //最小质因子,所以primes[j]*i的最小质因子就是primes[j];
                //2)当有i%primes[j]==0时,说明i的最小质因子是primes[j],因此primes[j]*i的最小质因子也就应该是
                //prime[j]，之后接着用st[primes[j+1]*i]=true去筛合数时，就不是用最小质因子去更新了,因为i有最小
                //质因子primes[j]<primes[j+1],此时的primes[j+1]不是primes[j+1]*i的最小质因子，此时就应该
                //退出循环，避免之后重复进行筛选。
                if(i%primes[j]==0) break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getPrime(n));
    }
}
