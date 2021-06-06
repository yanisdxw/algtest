package com.leetcode.p_divide_conquer;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class Solution53 {
    public int maxSubArray(int[] nums){
        return maxSubArray(nums,0,nums.length-1);
    }

    private int maxSubArray(int[] nums, int l, int r){
        if(l==r){
            return nums[l];
        }
        int m = (l+r)/2;
        int sum = 0;
        int lmax = Integer.MIN_VALUE;
        for (int i = m; i >=l; i--) {
            sum += nums[i];
            lmax = Math.max(sum, lmax);
        }
        sum = 0;
        int rmax = Integer.MIN_VALUE;
        for (int i = m+1; i <= r; i++) {
            sum += nums[i];
            rmax = Math.max(sum, rmax);
        }
        return Math.max(lmax+rmax, Math.max(maxSubArray(nums, l, m), maxSubArray(nums, m+1, r)));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ans = new Solution53().maxSubArray(nums);
        System.out.println(ans);
    }
}
