package com.leetcode.p_dp;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: [2,3,0,1,4]
 * 输出: 2
 */
public class Solution45 {
    //dp[i] 为跳跃到i所需要的最少步骤
    //dp[i] = min(dp[i-1], dp[i-2], dp[i-3], ...) + 1
    //dp[i] = dp[j] + 1 , dp[j] 为离i最远的能跳到j的位置
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1, j=0; i < n ; i++) {
            while (j+nums[j]<i) j++;
            dp[i] = dp[j] + 1;
        }
        return dp[n-1];
    }

    /**     非dp思路
     *     public int jump(int[] nums) {
     *         int length = nums.length;
     *         int end = 0;
     *         int maxPosition = 0;
     *         int steps = 0;
     *         for (int i = 0; i < length - 1; i++) {
     *             maxPosition = Math.max(maxPosition, i + nums[i]);
     *             if (i == end) {
     *                 end = maxPosition;
     *                 steps++;
     *             }
     *         }
     *         return steps;
     *     }
     *
     */
}
