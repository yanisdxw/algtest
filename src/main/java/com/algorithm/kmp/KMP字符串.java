package com.algorithm.kmp;

import java.io.*;

public class KMP字符串 {

    static int N = 100010;
    static int M = 1000010;
    static char[] p = new char[N];
    static int[] next = new int[N];
    static char[] s = new char[M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();
        System.arraycopy(cs, 0, p, 1, n);

        int m = Integer.parseInt(br.readLine());
        cs = br.readLine().toCharArray();
        System.arraycopy(cs, 0, s, 1, m);

        for(int i=2,j=0;i<=n;i++){
            while(j!=0 && p[j+1]!=p[i]) j = next[j];
            if(p[j+1]==p[i]) j++;
            next[i] = j;
        }

        for(int i=1,j=0;i<=m;i++){
            while(j!=0 && p[j+1]!=s[i]) j = next[j];
            if(p[j+1]==s[i]) j++;
            if(j==n){
                j = next[j];
                bw.write(i-n+" ");
            }
        }
        bw.flush();

    }
}
