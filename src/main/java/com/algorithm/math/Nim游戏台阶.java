package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/894/
 */
public class Nim游戏台阶 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i=1;i<=n;i++){
            int x = sc.nextInt();
            if(i%2!=0){
                res ^= x;
            }
        }
        if(res==0){
            System.out.print("No");
        }else{
            System.out.print("Yes");
        }
    }
}
