package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 图中点的层次 {

    private static int N = 100010;
    private static int M = 2*N;
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int[] h = new int[N];
    private static int idx;
    private static int[] d = new int[N];
    private static int n=0;

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static int bfs(){
        Arrays.fill(d,-1);
        d[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()){
            int t = q.poll();
            for(int i=h[t];i!=-1;i=ne[i]){
                int j = e[i];
                if(d[j]==-1){
                    d[j] = d[t] + 1;
                    q.offer(j);
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            add(b,a);
        }
        int res = bfs();
        System.out.println(res);
    }
}
