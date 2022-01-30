package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/863/
 */

public class 二分图的最大匹配 {
    private static int N = 510;
    private static int M = 100010;

    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int idx = 0;

    private static int n1 = 0;
    private static int n2 = 0;
    private static int m = 0;

    private static boolean[] st = new boolean[N];
    private static int[] match = new int[N];

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static boolean find(int u){
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(!st[j]){
                st[j] = true;
                if(match[j]==0||find(match[j])){
                    match[j] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        int res = 0;
        for(int i=1;i<=n1;i++){
            Arrays.fill(st,false);
            if(find(i)){
                res++;
            }
        }
        System.out.print(res);
    }
}
