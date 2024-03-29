package com.algorithm.prefixSum;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/800/
 */
public class 差分矩阵 {

    private static final int N =  1010;
    private static final int[][] b = new int[N][N];

    private static void insert(int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x2+1][y1] -= c;
        b[x1][y2+1] -= c;
        b[x2+1][y2+1] += c;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                insert(i,j,i,j,sc.nextInt());
            }
        }

        while(q-->0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            insert(x1,y1,x2,y2,c);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                b[i][j] += b[i][j-1] + b[i-1][j] - b[i-1][j-1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}
