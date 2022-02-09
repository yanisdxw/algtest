package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/874/
 */
public class 最大公约数 {
    private static int gcd(int a, int b){
        return b!=0?gcd(b,a%b):a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(gcd(a,b));
        }
    }
}
