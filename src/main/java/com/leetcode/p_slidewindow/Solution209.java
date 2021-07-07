package com.leetcode.p_slidewindow;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        int r = 0; int l = 0;
        while (r<nums.length){
            total+=nums[r++];
            while (total>=target){
                min = Math.min(min,r-l);
                total-=nums[l++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
//        int target = 4;
//        int[] nums = new int[]{1,4,4};
//        int target = 1;
//        int[] nums = new int[]{1};
        int ans = new Solution209().minSubArrayLen(target,nums);
        System.out.println(ans);
    }
}
