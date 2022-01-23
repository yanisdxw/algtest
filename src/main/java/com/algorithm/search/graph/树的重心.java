package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/848/
 */
public class 树的重心 {

    private static int N = 100010;
    private static int M = 2*N;
    private static int[] h = new int[N];
    private static int[] ne = new int[M];
    private static int[] e = new int[M];
    private static int idx = 0;
    private static int n = 0;
    private static int ans = Integer.MAX_VALUE;
    private static boolean[] s = new boolean[N];

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static int dfs(int u){
        s[u] = true; int size = 0; int sum = 1;
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(!s[j]){
                s[j] = true;
                int s = dfs(j);
                size = Math.max(s, size);
                sum += s;
            }
        }
        size = Math.max(size, n-sum);
        ans = Math.min(ans, size);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i=0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.print(ans);
    }
}
