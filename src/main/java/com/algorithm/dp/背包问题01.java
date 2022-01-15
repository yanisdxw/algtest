package com.algorithm.dp;

import java.util.Scanner;

/**
 * 01 背包问题
 */
public class 背包问题01 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] f = new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            int v = sc.nextInt();
            int w = sc.nextInt();
            for(int j=0;j<=V;j++){
                if(j<v){
                    f[i][j] = f[i-1][j];
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-v] + w);
                }
            }
        }
        System.out.print(f[N][V]);
    }

}
