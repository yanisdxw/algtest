package com.leetcode.bitwise;

/**
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class Solution190 {
    public int reverseBits(int n) {
        int ans = 0;//总数
        for (int i = 0; i < 32; i++) {
            ans<<=1;
            ans+=n&1;
            n>>=1;
        }
        return ans;
    }
}
