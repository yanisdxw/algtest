package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/851/
 */
public class Dijkstra求最短路I {

    private static int N = 510;
    private static int[][] g = new int[N][N];
    private static boolean[] st = new boolean[N];
    private static int n = 0;
    private static int max = (int) 10e8;

    private static int dijkstra(){
        int[] dist = new int[N];
        Arrays.fill(dist,max);
        dist[1] = 0;
        for (int i = 0; i < n-1; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if(!st[j] && (t==-1||dist[t]>dist[j])){
                    t = j;
                }
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j],dist[t]+g[t][j]);
            }
            st[t] = true;
        }
        if(dist[n]==max) return -1;
        return dist[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0;i<=n;i++){
            Arrays.fill(g[i], max);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            g[x][y] = Math.min(g[x][y],w);
        }

        int res = dijkstra();
        System.out.println(res);
    }
}
