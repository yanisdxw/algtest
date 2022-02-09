package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/885/
 */
public class 高斯消元解线性方程组 {

    private static int N = 110;
    private static double[][] a = new double[N][N];
    private static double eps = 1e-8;
    private static int n = 0;

    private static int guess(){
        int r = 0; int c = 0;
        for(;c<n;c++){
            //找到最大的列
            int t = r;
            for(int i=r;i<n;i++){
                if(Math.abs(a[t][c])<Math.abs(a[i][c])){
                    t = i;
                }
            }

            if(Math.abs(a[t][c])<eps){
                continue;
            }
            //与第r列交换位置
            for(int i=c;i<=n;i++){
                double tmp = a[r][i];
                a[r][i] = a[t][i];
                a[t][i] = tmp;
            }
            //将首列化为1
            for(int i=n;i>=c;i--){
                a[r][i] /= a[r][c];
            }
            //消去第r列的值，转化为上三角矩阵
            for (int i=r+1;i<n;i++) {
                if(Math.abs(a[i][c])>eps){
                    for (int j=n;j>=c;j--) {
                        a[i][j] -= a[r][j]*a[i][c];
                    }
                }
            }
            r++;
        }
        if(r<n){
            for (int i=r;i<n;i++) {
                //无解
                if(Math.abs(a[i][n])>eps){
                    return 2;
                }
            }
            //无穷解
            return 1;
        }
        //计算解
        for (int i=n-1;i>=0;i--) {
            for(int j=i+1;j<n;j++){
                a[i][n] -= a[i][j]*a[j][n];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+1; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        int res = guess();
        if(res==2){
            System.out.println("No solution");
        }else if(res==1){
            System.out.println("Infinite group solutions");
        }else {
            for(int i=0;i<n;i++){
                if(Math.abs(a[i][n])<eps){
                    a[i][n] = 0;
                }
                System.out.println(String.format("%.2f", a[i][n]));
            }
        }
    }
}