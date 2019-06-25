package com.interview.others.bitwise;

public class leetcode_231 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }
}
