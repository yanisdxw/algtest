package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/869/
 */
public class 分解质因数 {

    private static void divide(int n){
        for (int i = 2; i <= n/i; i++) {
            if(n%i==0){
                int s = 0;
                while (n%i==0){
                    n /= i;
                    s++;
                }
                System.out.println(i+" "+s);
            }
        }
        if(n>1){
            System.out.println(n+" "+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            int a = sc.nextInt();
            divide(a);
            System.out.println();
        }
    }
}
