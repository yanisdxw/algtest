package com.leetcode.p_math;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Solution69 {

    /***
     *     public int mySqrt(int x) {
     *         if(x==0) return x;
     *         long pow; int mid;
     *         int l = 1; int r = x;
     *         while(l<=r){
     *             mid = l + (r-l)/2;
     *             pow = mid * mid;
     *             if(pow==x){
     *                 return mid;
     *             }else if(pow>x){
     *                 r = mid -1;
     *             }else {
     *                 l = mid +1;
     *             }
     *         }
     *         return r;
     *     }
     */



    public int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


    public static void main(String[] args) {
        int solution = new Solution69().mySqrt2(81);
        System.out.println(solution);
    }
}
