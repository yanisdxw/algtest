package com.algorithm.search.graph;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/856/
 */
public class Floyd求最短路 {

    private static int N = 200;
    private static int M = 20000;
    private static int[][] d = new int[N][N];
    private static int n = 0;
    private static int m = 0;
    private static int k = 0;
    private static int max = (int)10e9;

    private static void floyd(){
        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i==j) d[i][j] = 0;
                else d[i][j] = max;
            }
        }
        while (m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }
        floyd();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(d[a][b]>max/2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }

}
