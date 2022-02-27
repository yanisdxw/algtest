package com.algorithm.heap;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/841/
 */

public class 模拟堆 {
    private static int N = 100010;
    private static int[] h = new int[N];
    // 第k个插入值的下标
    private static int[] ph = new int[N];
    // 下标为i的值对应的k
    private static int[] hp = new int[N];

    private static int size = 0;

    private static void down(int u){
        int t = u;
        if(2*u<=size && h[2*u]<h[t]) t = 2*u;
        if(2*u+1<=size && h[2*u+1]<h[t]) t = 2*u+1;
        if(t!=u){
            heapSwap(u, t);
            down(t);
        }
    }

    private static void up(int u){
        while(u/2>0 && h[u/2]>h[u]){
            heapSwap(u, u/2);
            u /= 2;
        }
    }

    private static void heapSwap(int a, int b){
        swap(hp[a],hp[b],ph);
        swap(a,b,hp);
        swap(a,b,h);
    }

    private static void swap(int a, int b, int[] h){
        int tmp = h[a];
        h[a] = h[b];
        h[b] = tmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = 0;
        int cnt = 0;
        while(n-->0){
            String input = sc.nextLine();
            String[] params = input.split(" ");
            String op = params[0];
            switch (op){
                case "I":{
                    Integer v = Integer.parseInt(params[1]);
                    size++;
                    m++;
                    h[size] = v;
                    ph[m] = size; hp[size]=m;
                    up(size);
                } break;
                case "PM":{
                    System.out.println(h[1]);
                } break;
                case "DM":{
                    heapSwap(1,size);
                    size--;
                    down(1);
                } break;
                case "D":{
                    int k = Integer.parseInt(params[1]);
                    k = ph[k];
                    heapSwap(k,size);
                    size--;
                    up(k);
                    down(k);
                } break;
                case "C":{
                    int k = Integer.parseInt(params[1]);
                    int v = Integer.parseInt(params[2]);
                    k = ph[k];
                    h[k] = v;
                    up(k);
                    down(k);
                } break;
                default: break;
            }
        }
    }
}
