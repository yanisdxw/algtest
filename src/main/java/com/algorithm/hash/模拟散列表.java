package com.algorithm.hash;

import java.util.Arrays;
import java.util.Scanner;

public class 模拟散列表 {
    private static int N = 100003;
    private static int[] h = new int[N];

    private static int[] e =  new int[N];
    private static int[] ne = new int[N];
    private static int idx = 0;

    private static void insert(int x){
        int k = (x%N + N)%N;
        e[idx] = x; ne[idx] = h[k]; h[k]=idx++;
    }

    private static boolean find(int x){
        int k = (x%N + N)%N;
        boolean flag = false;
        for(int i=h[k];i!=-1;i=ne[i]){
            if(e[i]==x){
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Arrays.fill(h,-1);
        while(n-->0){
            String input = sc.nextLine();
            String[] params = input.split(" ");
            String op = params[0];
            int x = Integer.parseInt(params[1]);
            if("I".equals(op)){
                insert(x);
            }else{
                if(find(x)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
