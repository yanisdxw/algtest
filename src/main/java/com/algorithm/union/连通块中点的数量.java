package com.algorithm.union;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/839/
 */
public class 连通块中点的数量 {

    private static int N = 100010;
    private static int[] p = new int[N];
    private static int[] size = new int[N];

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
            size[i] = 1;
        }
        for(int i=0;i<m;i++){
            String op = sc.next();
            if("C".equals(op)){
                int a = sc.nextInt();
                int b = sc.nextInt();
                a = find(a);
                b = find(b);
                if(a!=b){
                    p[a] = b;
                    size[b] += size[a];
                }
            }else if("Q1".equals(op)){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(find(a)==find(b)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else{
                int a = sc.nextInt();
                System.out.println(size[find(a)]);
            }
        }
    }
}
