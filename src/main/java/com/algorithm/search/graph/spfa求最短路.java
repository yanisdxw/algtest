package com.algorithm.search.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/853/
 */
public class spfa求最短路 {

    private static int N = 100010;
    private static int M = 100010;
    private static int max = (int) 10e8;

    private static int[] e = new int[M];
    private static int[] ne = new int[N];
    private static int[] h = new int[N];
    private static int[] w = new int[N];
    private static int idx = 0;
    private static int[] dist = new int[N];
    private static boolean[] st = new boolean[N];

    private static int n = 0;
    private static int m = 0;

    private static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    private static int spfa(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        st[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()){
            int t = q.poll();
            for(int i=h[t];i!=-1;i=ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if(!st[j]){
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0; i < m; i++) {
            add(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int ans = spfa();
        if(ans>max/2) {
            System.out.print("impossible");
            return;
        }
        System.out.println(ans);
    }

}
