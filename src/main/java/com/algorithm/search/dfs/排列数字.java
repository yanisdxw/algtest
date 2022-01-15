package com.algorithm.search.dfs;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/844/
 */

public class 排列数字 {
    private static int n;
    private static int[] path;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n+1];
        path = new int[n];
        dfs(0);
    }

    private static void dfs(int u){
        if(u==n){
            for(int i=0;i<n;i++){
                System.out.print(path[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                path[u] = i;
                dfs(u+1);
                visited[i] = false;
            }
        }
    }
}
