package com.algorithm.math;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 求组合数IV {

    private static int N = 5010;
    private static int cnt = 0;
    private static int[] primes = new int[N];
    private static boolean[] st = new boolean[N];
    private static int[] sum = new int[N];

    //筛质数
    private static void getPrimes(int n){
        for (int i = 2; i <= n; i++) {
            if(!st[i]) primes[cnt++] = i;
            for (int j = 0; i*primes[j]<=n; j++) {
                st[i*primes[j]] = true;
                if(i%primes[j]==0) break;
            }
        }
    }

    // 对p的各个<=a的次数算整除下取整倍数
    private static int get(int n, int p)
    {
        int res=0;
        while(n>0)
        {
            res+=n/p;
            n/=p;
        }
        return res;
    }

    //高精度乘法
    private static List<Integer> mul(List<Integer> vec, int b){
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < vec.size()||t!=0; i++) {
            if(i<vec.size()) t+=vec.get(i)*b;
            res.add(t%10);
            t/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        getPrimes(a);
        //p的次数
        for(int i=0;i<cnt;i++){
            int p = primes[i];
            sum[i] = get(a,p)-get(a-b,p)-get(b,p);
            System.out.println(p+" "+sum[i]);
        }
        List<Integer> res = new ArrayList();
        res.add(1);
        for(int i=0;i<cnt;i++){
            for(int j=0;j<sum[i];j++){
                res = mul(res, primes[i]);
            }
        }
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i));
        }
    }
}
