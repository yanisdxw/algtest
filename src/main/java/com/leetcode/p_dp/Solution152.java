package com.leetcode.p_dp;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        //dp_max代表以i为结尾的连续数组积的最大值
        int[] dp_max = new int[nums.length+1];
        //dp_min代表以i为结尾的连续数组积的最小值
        int[] dp_min = new int[nums.length+1];
        dp_max[1] = nums[0];
        dp_min[1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp_max[i+1] = Math.max(dp_max[i]*nums[i], Math.max(dp_min[i]*nums[i],nums[i]));
            dp_min[i+1] = Math.min(dp_min[i]*nums[i], Math.min(dp_max[i]*nums[i],nums[i]));
            max = Math.max(dp_max[i+1],max);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{2,3,-2,4};
        int[] nums = new int[]{2,-5,-2,-4,3};
        int ans = new Solution152().maxProduct(nums);
        System.out.println(ans);
    }
}
