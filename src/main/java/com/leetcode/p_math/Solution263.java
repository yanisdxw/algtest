package com.leetcode.p_math;

/**
 * 263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 *
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 */
public class Solution263 {

    /**
     *
     *     public boolean isUgly(int n) {
     *         if(n==0) return false;
     *         if(n==1) return true;
     *         int mod;
     *         int a;
     *         while (true){
     *             mod = n%5;
     *             a = n/5;
     *             if(mod==0 && a==1){
     *                 return true;
     *             }
     *             if(mod!=0) break;
     *             n = a;
     *         }
     *         while (true){
     *             mod = n%3;
     *             a = n/3;
     *             if(mod==0 && a==1){
     *                 return true;
     *             }
     *             if(mod!=0) break;
     *             n = a;
     *         }
     *         while (true){
     *             mod = n%2;
     *             a = n/2;
     *             if(mod==0 && a==1){
     *                 return true;
     *             }
     *             if(mod!=0) break;
     *             n = a;
     *         }
     *         return false;
     *     }
     * */

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        boolean ans = new Solution263().isUgly(7);
        System.out.println(ans);
    }
}
