package com.leetcode.p_dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        //设dp[i]为以i结尾的序列最长递增序列长度
        int[] dp = new int[n+1];
        int max_len = 0;
        Arrays.fill(dp,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                //在i之前的数字j如果比i小，说明可以在nums[j]的基础上+1
                if(nums[i-1]>nums[j-1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }
}
