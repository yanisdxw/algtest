package com.interview.greedy.leetcode_455;


import java.util.Arrays;
import java.util.Collections;

public class leetcode_455 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1, si = s.length - 1;
        int res = 0;
        while(gi >= 0 && si >= 0){
            if(s[si] >= g[gi]){
                res ++;
                si --;
            }
            gi --;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
