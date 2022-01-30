package com.algorithm.search.graph;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/861/
 */

public class Kruskal算法求最小生成树 {

    private static int N = 100010;
    private static int M = 2*N;
    private static int n = 0;
    private static int m = 0;
    private static int[] p = new int[N];
    private static List<Edge> edges = new ArrayList<>();
    private static int max = (int)10e8;

    private static int find(int x){
        if(x!=p[x]) p[x] = find(p[x]);
        return p[x];
    }

    private static int kruskal(){
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int cnt = 0; int res = 0;
        for(Edge edge:edges){
            int a = find(edge.a);
            int b = find(edge.b);
            if(a!=b){
                p[a] = b;
                res += edge.w;
                cnt ++;
            }
        }
        if(cnt<n-1) return max;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            Edge edge = new Edge(a,b,w);
            edges.add(edge);
        }
        int res = kruskal();
        if(res==max) System.out.print("impossible");
        else System.out.println(res);
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
