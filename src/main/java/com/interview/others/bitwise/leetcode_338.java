package com.interview.others.bitwise;

public class leetcode_338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=1;i<=num;i++){
            res[i] += res[i&(i-1)]+1;
        }
        return res;
    }
}
