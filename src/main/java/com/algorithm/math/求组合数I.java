package com.algorithm.math;

import java.util.Scanner;

public class 求组合数I {
    private static int N = 2010;
    private static int mod = (int) 1e9+7;
    private static int[][] c = new int[N][N];

    private static void init(){
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0) {
                    c[i][j] = 1;
                }else{
                    c[i][j] = (c[i-1][j-1] + c[i-1][j])%mod;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        init();
        while(n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(c[a][b]);
        }
    }
}
