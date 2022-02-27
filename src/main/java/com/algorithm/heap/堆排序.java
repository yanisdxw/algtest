package com.algorithm.heap;

import java.util.Scanner;

/**
 * https://www.acwing.com/activity/content/code/content/2597660/
 */

public class 堆排序 {
    private static int N = 100010;
    private static int[] h = new int[N];
    private static int size = 0;

    private static void down(int u){
        int t = u;
        if(2*u<=size && h[2*u]<h[t]) t = 2*u;
        if(2*u+1<=size && h[2*u+1]<h[t]) t = 2*u+1;
        if(t!=u){
            swap(u, t);
            down(t);
        }
    }

    private static void swap(int a, int b){
        int tmp = h[a];
        h[a] = h[b];
        h[b] = tmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=1;i<=n;i++){
            h[i] = sc.nextInt();
        }
        size = n;
        for(int i=n/2;i>0;i--){
            down(i);
        }
        while(m-->0){
            System.out.print(h[1]+" ");
            h[1] = h[size--];
            down(1);
        }
    }
}
