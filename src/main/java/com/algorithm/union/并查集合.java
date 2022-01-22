package com.algorithm.union;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/838/
 */
public class 并查集合 {

    private static int N = 100010;
    private static int[] p = new int[N];

    private static int find(int x){
        if(p[x]!=x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=1; i<=n;i++){
            p[i] = i;
        }
        for(int i=0;i<m;i++){
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if("M".equals(op)){
                p[find(a)] = find(b);
            }else{
                if(find(a)==find(b)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
