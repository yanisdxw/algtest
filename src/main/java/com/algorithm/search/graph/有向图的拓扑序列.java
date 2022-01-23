package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/850/
 */
public class 有向图的拓扑序列 {

    private static int N = 100010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int[] h = new int[N];
    private static int idx = 0;
    private static int n = 0;
    private static int[] d;
    private static Queue<Integer> res = new LinkedList<>();

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static boolean topsort(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(d[i]==0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int t = q.poll();
            res.offer(t);
            for(int i=h[t];i!=-1;i=ne[i]){
                int j = e[i];
                if(--d[j]==0){
                    q.offer(j);
                }
            }
        }
        return res.size()==n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = sc.nextInt();
        d = new int[n+1];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            d[b]++;
        }
        if(topsort()){
            while (!res.isEmpty()){
                System.out.print(res.poll()+" ");
            }
        }else {
            System.out.println("-1");
        }
    }
}
