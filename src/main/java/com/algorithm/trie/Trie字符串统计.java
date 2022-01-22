package com.algorithm.trie;

import java.util.Scanner;

public class Trie字符串统计 {

    private static int N = 100010;
    private static int[] cnt = new int[N];
    private static int[][] son = new int[N][26];
    private static int idx = 0;

    private static void insert(String s){
        int p = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            if(son[p][c]==0){
                son[p][c] = ++idx;
            }
            p = son[p][c];
        }
        cnt[p]++;
    }

    private static int query(String s){
        int p = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            if(son[p][c]==0){
                return 0;
            }else{
                p = son[p][c];
            }
        }
        return cnt[p];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            String value = sc.next();
            switch (op){
                case "I": insert(value); break;
                case "Q": System.out.println(query(value)); break;
            }
        }
    }
}
