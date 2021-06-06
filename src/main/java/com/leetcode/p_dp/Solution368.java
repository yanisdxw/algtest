package com.leetcode.p_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        //先排序
        Arrays.sort(nums);
        //设dp[i]为以i结尾最大子集长度
        int[] dp = new int[nums.length+1];
        //g[i]记录第i个数前一个能整除的位置
        int[] g = new int[nums.length+1];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            int len = 1; //最大长度
            int prev = i;
            for (int j = 0; j < i; j++) {
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>len){
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            dp[i] = len;
            g[i] = prev;
        }

        int max = -1;
        int prev_index = -1;
        for (int i = 0; i < dp.length; i++) {
            if(max<dp[i]){
                max = dp[i];
                prev_index = i;
            }
        }
        //g[i]类似链表一样记录最大数组的索引
        List<Integer> ans = new ArrayList<>();
        while (ans.size()<max){
            ans.add(nums[prev_index]);
            prev_index = g[prev_index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        List<Integer> ans = new Solution368().largestDivisibleSubset(nums);
        System.out.println(ans);
    }
}
