package com.algorithm.math;

import java.util.Scanner;

public class 能被整除的数 {
    private static int N = 20;
    private static int[] p = new int[N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            p[i] = sc.nextInt();
        }
        int res = 0;
        for(int i=1;i<(1<<m);i++){
            int t=1; int s=0;
            for(int j=0;j<m;j++){
                if((i>>j&1)!=0){
                    if((long)t*p[j]>n){
                        t=-1;
                        break;
                    }
                    t *= p[j];
                    s++;
                }
            }
            if(t==-1) continue;
            if((s&1)!=0){
                res += n/t;
            }else{
                res -= n/t;
            }
        }
        System.out.print(res);
    }
}
