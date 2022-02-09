package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/870/
 */
public class 筛质数 {
    private static int N = 1000010;
    private static boolean[] st = new boolean[N];

    private static int getPrime(int n){
        int cnt = 0;
        for (int i = 2; i <=n ; i++) {
            if(!st[i]){
                cnt++;
                for (int j = i; j <=n ; j+=i) {
                    st[j]=true;
                }
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
