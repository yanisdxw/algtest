package com.algorithm.math;

import java.util.Scanner;

public class Nim游戏 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while(n-->0){
            int x = sc.nextInt();
            res ^= x;
        }
        if(res==0){
            System.out.print("No");
        }else{
            System.out.print("Yes");
        }
    }
}
