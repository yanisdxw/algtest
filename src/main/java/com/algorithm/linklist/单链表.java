package com.algorithm.linklist;

import java.util.*;

public class 单链表 {

    private static int N = 100000;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int head;
    private static int idx;

    private static void init(){
        head = -1;
        idx = 0;
    }

    private static void addToHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    private static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    private static void remove(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args){
        init();
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        while(m--!=0){
            String input = sc.nextLine();
            String[] params = input.split(" ");
            switch(params[0]){
                case "H": addToHead(Integer.parseInt(params[1])); break;
                case "I": add(Integer.parseInt(params[1])-1, Integer.parseInt(params[2])); break;
                case "D": {
                    int k = Integer.parseInt(params[1]);
                    if(k==0) {
                        head = ne[head];
                    }else{
                        remove(k-1);
                    }
                    break;
                }
                default: break;
            }
        }
        for(int i=head;i!=-1;i=ne[i]){
            System.out.print(e[i]+" ");
        }
    }
}
