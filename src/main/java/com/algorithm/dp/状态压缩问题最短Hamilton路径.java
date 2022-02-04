package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/93/
 */
public class 状态压缩问题最短Hamilton路径 {

    private static int N = 20;
    private static int[][] f = new int[1<<N][N];
    private static int[][] w = new int[N][N];
    private static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<(1<<n);i++){
            Arrays.fill(f[i], Integer.MAX_VALUE>>1);
        }
        f[1][0] = 0;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i>>j&1)==1){ // 如果当态前点集包含点j, 那么进行状态转移
                    for(int k=0;k<n;k++){
                        if((i-(1<<j)>>k&1)==1){ ////如果从当前状态经过点集i中, 去掉点j后, i仍然包含点k, 那么才能从点k转移到点j
                            f[i][j] = Math.min(f[i][j],f[i-(1<<j)][k]+w[j][k]);
                        }
                    }
                }
            }
        }
        System.out.println(f[(1<<n)-1][n-1]);
    }
}
