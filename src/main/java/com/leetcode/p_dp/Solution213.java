package com.leetcode.p_dp;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻
 * 的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 */
public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        //dp[i]代表遍历到第i时所能偷到的最大金额
        int n = nums.length;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        //dp1：抢第一个
        dp1[0] = 0; dp1[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i-1]);
        }
        //dp2：不抢第一个
        dp2[0] = 0; dp2[1] = 0;
        for (int i = 2; i <= n-1; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
        }
        return Math.max(dp1[n-1], dp2[n-2]+nums[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int ans = new Solution213().rob(nums);
        System.out.println(ans);
    }
}
