package com.leetcode.p_dp;


/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return false;
        }
        //dp[i]表示遍历到i时还能跳跃的最大长度
        int[] dp = new int[nums.length+1];
        for (int i = 1; i <= nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1]-1, nums[i-1]);
            if(nums[i-1]==0){
                if(dp[i]<1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};
        boolean ans1 = new Solution55().canJump(nums1);
        boolean ans2 = new Solution55().canJump(nums2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
