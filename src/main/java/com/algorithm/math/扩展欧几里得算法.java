package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/879/
 */
public class 扩展欧几里得算法 {
    private static int exgcd(int a, int b, int[] x, int[] y){
        if(b==0){
            x[0] = 1; y[0] = 0;
            return a;
        }
        int d = exgcd(b,a%b,y,x);
        y[0]-=a/b*x[0];
        return d;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] x = new int[1];
            int[] y = new int[1];
            exgcd(a,b,x,y);
            System.out.println(x[0]+" "+y[0]);
        }
    }
}
