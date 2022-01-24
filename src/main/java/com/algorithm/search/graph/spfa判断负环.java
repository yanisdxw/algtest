package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/854/
 */
public class spfa判断负环 {

    private static int N = 2010;
    private static int M = 100010;

    private static int[] e = new int[M];
    private static int[] ne = new int[N];
    private static int[] h = new int[N];
    private static int[] w = new int[N];
    private static int idx = 0;
    private static int[] dist = new int[N];
    private static boolean[] st = new boolean[N];
    //最短路的边的数量
    private static int[] cnt = new int[N];

    private static int n = 0;
    private static int m = 0;

    private static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    private static boolean spfa(){

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            st[i] = true;
            q.offer(i);
        }
        while (!q.isEmpty()){
            int t = q.poll();
            st[t] = false;
            for(int i=h[t];i!=-1;i=ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t]+1;
                    if(cnt[j]>=n) return true;
                    if(!st[j]){
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0; i < m; i++) {
            add(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        if(spfa()){
            System.out.print("Yes");
        }else {
            System.out.println("No");
        }
    }
}
