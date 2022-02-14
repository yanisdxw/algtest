package com.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Nim游戏集合 {

    private static int N = 110;
    private static int M = 100010;
    private static int[] s = new int[N];
    private static int[] f = new int[M];
    private static int k = 0;

    private static int sg(int x){
        if(f[x]!=-1) return f[x];
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < k; i++) {
            if(x>=s[i]) set.add(sg(x-s[i]));
        }
        //mex操作
        for(int i=0;;i++){
            if(!set.contains(i)){
                return f[x] = i;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int res = 0;
        Arrays.fill(f,-1);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int tmp = sg(x);
            System.out.println(tmp);
            res ^= tmp;
        }
        if(res==0){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }
    }
}
