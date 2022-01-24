package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/855/
 */
public class 有边数限制的最短路 {

    private static int N = 510;
    private static int M = 10010;
    private static int k = 0;
    private static int n = 0;
    private static int m = 0;
    private static int max = (int) 10e8;

    private static int[] dist = new int[N];
    //暂存上一次迭代的结果
    private static int[] last = new int[N];
    private static Edge[] edges = new Edge[M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(a,b,w);
        }
        bellmFd();
        if(dist[n]>max/2) {
            System.out.print("impossible");
            return;
        }
        System.out.println(dist[n]);
    }

    private static void bellmFd(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            last = Arrays.copyOf(dist, N);
            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], last[a]+w);
            }
        }
    }

    static class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
