package com.algorithm.hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acwing.com/problem/content/843/
 */
public class 字符串哈希 {
    private static int N = 100010;
    private static int P = 131;

    private static long mod = Long.MAX_VALUE;
    private static long[] h = new long[N];
    private static long[] p = new long[N];

    private static void init(String s){
        p[0] = 1;
        for(int i=1;i<=s.length();i++){
            int c = s.charAt(i-1)-'a'+1;
            h[i] = (h[i-1]*P + c)%mod;
            p[i] = (p[i-1]*P)%mod;
        }
    }

    private static long get(int l, int r){
        return h[r] - h[l-1]*p[r-l+1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        String[] params = input.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        String str = in.readLine();
        init(str);
        while(m-->0){
            String[] values = in.readLine().split(" ");
            int l1 = Integer.parseInt(values[0]);
            int r1 = Integer.parseInt(values[1]);
            int l2 = Integer.parseInt(values[2]);
            int r2 = Integer.parseInt(values[3]);
            if(get(l1,r1)==get(l2,r2)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
