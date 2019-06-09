package com.interview.dp;

import java.util.Arrays;

public class fibonacci {

    private static int[] memo;

    public static int fab(int n){
        if(n==0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        if(memo[n]==-1)
            return fab(n-1) + fab(n-2);
        return memo[n];
    }

    public static void main(String[] args) {

        int n = 10;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int res = fab(n);
        System.out.println(res);
    }
}
