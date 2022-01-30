package com.algorithm.search.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/862/
 */
public class 染色法判定二分图 {
    private static int N = 100010;
    private static int M = 2*N;

    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int[] h = new int[N];
    private static int idx = 0;

    private static int[] color = new int[N];
    private static int n = 0;
    private static int m = 0;

    private static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static boolean dfs(int u, int c){
        color[u] = c;
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(color[j]==0){
                if(!dfs(j,3-c)) return false;
            }else if(color[j]==c) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b); add(b,a);
        }
        boolean flag = true;
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                if(!dfs(i,1)){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}
