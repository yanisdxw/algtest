package com.algorithm.bsearch;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/792/
 */
public class 数的三次方根 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        double l = -10000.0;
        double r = 10000.0;
        while(r-l>10e-8){
            double mid = (l+r)/2;
            if(mid*mid*mid>=m){
                r = mid;
            }else{
                l = mid;
            }
        }
        System.out.print(String.format("%.6f", l));
    }
}
