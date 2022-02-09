package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/875/
 */
public class 欧拉函数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0){
            int a = sc.nextInt();
            long res = a;
            for (int i = 2; i <= a/i ; i++) {
                if(a%i==0){
                    res = res*(i-1)/i;
                    while (a%i==0) a /= i;
                }
            }
            if(a>1){
                res = res*(a-1)/a;
            }
            System.out.println(res);
        }
    }
}
