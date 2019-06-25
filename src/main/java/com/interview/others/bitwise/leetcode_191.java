package com.interview.others.bitwise;

public class leetcode_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
