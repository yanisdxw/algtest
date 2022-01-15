package com.algorithm.search.dfs;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/845/
 */
public class N皇后 {

    private static int N = 20;
    private static int n;
    private static char[][] path;
    private static boolean[] col = new boolean[N];
    private static boolean[] dg = new boolean[N];
    private static boolean[] udg = new boolean[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        path = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j] = '.';
            }
        }
        dfs(0);
    }

    //u 代表第u行的皇后
    private static void dfs(int u){
        if(u==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(path[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //尝试把u放在第i列
        for(int i=0;i<n;i++){
            //方阵中对角线的表示法 dg[i+u] 与 udg[n-u+i]
            if(!col[i] && !dg[i+u] && !udg[n-u+i]){
                col[i] = dg[i+u] = udg[n-u+i] = true;
                path[u][i] = 'Q';
                dfs(u+1);
                col[i] = dg[i+u] = udg[n-u+i] = false;
                path[u][i] = '.';
            }
        }
    }
}
