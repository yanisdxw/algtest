package com.algorithm.math;

import java.util.Scanner;

public class 高斯消元解异或方程组 {

    private static int N = 110;
    private static int[][] a = new int[N][N];

    private static int n = 0;

    private static int gauss(){
        int r = 0; int c = 0;
        for(;c<n;c++){
            //找到最大的列
            int t = r;
            for(int i=r;i<n;i++){
                if(a[i][c]!=0){
                    t = i;
                }
            }

            if(a[t][c]==0){
                continue;
            }
            //与第r列交换位置
            for(int i=c;i<=n;i++){
                int tmp = a[r][i];
                a[r][i] = a[t][i];
                a[t][i] = tmp;
            }
            //消去第r列的值，转化为上三角矩阵
            for (int i=r+1;i<n;i++) {
                if(a[i][c]!=0){
                    for (int j=n;j>=c;j--) {
                        a[i][j] ^= a[r][j];
                    }
                }
            }
            r++;
        }
        if(r<n){
            for (int i=r;i<n;i++) {
                //无解
                if(a[i][n]!=0){
                    return 2;
                }
            }
            //无穷解
            return 1;
        }
        //计算解
        for (int i=n-1;i>=0;i--) {
            for(int j=i+1;j<n;j++){
                a[i][n] ^= a[i][j]*a[j][n];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int res = gauss();
        if(res==2){
            System.out.println("No solution");
        }else if(res==1){
            System.out.println("Multiple sets of solutions");
        }else {
            for(int i=0;i<n;i++){
                System.out.println(a[i][n]);
            }
        }
    }
}
