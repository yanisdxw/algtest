package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/903/
 */

public class 记忆化搜索滑雪 {

    private static int N = 310;
    private static int[][] h = new int[N][N];
    private static int[][] f = new int[N][N];
    private static int n = 0;
    private static int m = 0;

    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{1,0,-1,0};

    private static int dp(int x, int y){
        if(f[x][y]!=-1) return f[x][y];
        f[x][y] = 1;
        for(int i=0;i<4;i++){
            int ux = x + dx[i];
            int uy = y + dy[i];
            if(1<=ux && ux<=n && 1<=uy && uy<=m && h[ux][uy]<h[x][y]){
                f[x][y] = Math.max(f[x][y],dp(ux,uy)+1);
            }
        }
        return f[x][y];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                h[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            Arrays.fill(f[i],-1);
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                res = Math.max(res, dp(i,j));
            }
        }
        System.out.print(res);
    }
}
