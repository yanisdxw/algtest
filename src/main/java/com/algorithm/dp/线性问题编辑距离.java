package com.algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 线性问题编辑距离 {
    private static int N = 15;
    private static List<String> st = new ArrayList();
    private static int n = 0;
    private static int m = 0;

    private static int editDistance(String a, String b){
        int la = a.length(); int lb = b.length();
        int[][] f = new int[N][N];
        for(int i=0;i<=la;i++){
            f[i][0] = i;
        }
        for(int i=0;i<=lb;i++){
            f[0][i] = i;
        }
        for(int i=1;i<=la;i++){
            for(int j=1;j<=lb;j++){
                f[i][j] = Math.min(f[i][j-1],f[i-1][j])+1;
                f[i][j] = Math.min(f[i][j],f[i-1][j-1]+(a.charAt(i-1)==b.charAt(j-1)?0:1));
            }
        }
        return f[la][lb];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<n;i++){
            String s = sc.next();
            st.add(s);
        }
        while(m-->0){
            String input = sc.next();
            int lim = sc.nextInt();
            int res = 0;
            for(String s:st){
                if(editDistance(s,input)<=lim){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
