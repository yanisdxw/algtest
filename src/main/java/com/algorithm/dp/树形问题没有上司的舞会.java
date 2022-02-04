package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/287/
 */
public class 树形问题没有上司的舞会 {
    private static int N = 6010;
    private static int[] happy = new int[N];
    private static int n = 0;
    private static int[][] f = new int[N][2];
    private static boolean[] hasFather = new boolean[N];

    private static int[] h = new int[N];
    private static int[] ne = new int[N];
    private static int[] e = new int[N];
    private static int idx = 0;

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static void dfs(int u){
        f[u][1] = happy[u];
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][1], f[j][0]);
            f[u][1] += f[j][0];
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=1;i<=n;i++){
            int w = sc.nextInt();
            happy[i] = w;
        }
        Arrays.fill(h,-1);
        for(int i=1;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(b,a);
            hasFather[a] = true;
        }

        int root = 1;
        while(hasFather[root]) root++;
        dfs(root);

        int res = Math.max(f[root][1], f[root][0]);
        System.out.print(res);
    }
}
