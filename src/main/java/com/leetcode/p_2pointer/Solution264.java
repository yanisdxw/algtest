package com.leetcode.p_2pointer;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        for(int x=1,y=1,z=1,i=2;i<=n;i++){
            int a = nums[x]*2;
            int b = nums[y]*3;
            int c = nums[z]*5;
            int min = Math.min(Math.min(a,b),c);
            if(min==a) x++;
            if(min==b) y++;
            if(min==c) z++;
            nums[i] = min;
        }
        return nums[n];
    }
}
