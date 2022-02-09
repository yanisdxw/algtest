package com.algorithm.math;

import java.util.Scanner;

/**
 * 试除法判定质数
 */
public class 试除法判定质数 {

    private static boolean isPrime(int n){
        if(n<2) return false;
        for (int i = 2; i <= n/i ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(isPrime(n));
    }
}
