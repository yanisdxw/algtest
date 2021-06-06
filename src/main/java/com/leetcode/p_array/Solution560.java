package com.leetcode.p_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Solution560 {

    /**
     *     public int subarraySum(int[] nums, int k) {
     *         int ans = 0;
     *         //暴力搜
     *         int len = nums.length;
     *         int sum = 0;
     *         for (int i = 0; i < len; i++) {
     *             for (int j = i; j < len; j++) {
     *                 sum += nums[j];
     *                 if(sum==k) ans++;
     *             }
     *             sum = 0;
     *         }
     *         return ans;
     *     }
     */

    //前缀和+哈希表
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和为0的有一个
        map.put(0,1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre-k)){
                ans += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,-1,1,2};
        int ans = new Solution560().subarraySum(nums,2);
        System.out.println(ans);
    }
}
