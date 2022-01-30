package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/860/
 */

public class Prim算法求最小生成树 {

    private static int N = 510;
    private static int M = 100010;
    private static int[][] g = new int[N][N];
    private static int max = (int)10e8;
    private static boolean[] st = new boolean[N];

    private static int n = 0;
    private static int m = 0;

    private static int prim(){
        int res = 0;
        int[] dist = new int[n+1];
        dist[1] = 0;
        for (int i = 0; i < n ; i++) {
            int t = -1;
            //从第1个点开始找
            for (int j = 1; j <= n; j++) {
                if(!st[j]&&(t==-1 || dist[j]<dist[t])){
                    t = j;
                }
            }
            if(dist[t]==max) return max;
            res += dist[t];
            st[t] = true;
            //从第1个点开始更新
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], max);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            g[a][b] = Math.min(g[a][b],w);
            g[b][a] = Math.min(g[b][a],w);
        }
        int res = prim();
        if(res==max){
            System.out.println("impossible");
        }else {
            System.out.println(res);
        }
    }

}
