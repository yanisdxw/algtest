package com.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.acwing.com/problem/content/896/
 */
public class Nim游戏拆分 {
    private static int N = 110;
    private static int[] f = new int[N];

    private static int sg(int x){
        if(f[x]!=-1) return f[x];
        TreeSet<Integer> s = new TreeSet();
        for(int i=0;i<x;i++){
            for(int j=0;j<=i;j++){
                s.add(sg(i)^sg(j));
            }
        }
        for(int i=0;;i++){
            if(!s.contains(i)){
                return f[x] = i;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        Arrays.fill(f,-1);
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            res ^= sg(x);
        }
        if(res==0){
            System.out.print("No");
        }else{
            System.out.print("Yes");
        }
    }
}
