package com.leetcode.p_slidewindow;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 */
public class Solution220 {
    //维护一个距离为k的滑动窗，记录窗内的最大值和最小值
    //TreeSetTreeSet 基于红黑树，查找和插入都是 O(logk) 复杂度。整体复杂度为 O(nlogk)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //用treeset作为存储滑动窗的数据结构
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long u  = nums[i]*1L;
            Long low = set.floor(u); //low：小于等于u的最大值
            Long high = set.ceiling(u); //high：大于等于u的最小值
            if(low!=null && u-low<=t*1L) return true;
            if(high!=null && high-u<=t*1L) return true;
            set.add(u);
            if(i>=k) set.remove(nums[i-k]*1L);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
        TreeSet<Long> set = new TreeSet<>();
        int l = 0; int r = 0;
        while (r<nums.length){
            Long u  = nums[r++]*1L;
            Long low = set.floor(u); //low：小于等于u的最大值
            Long high = set.ceiling(u); //high：大于等于u的最小值
            if(low!=null && u-low<=t*1L) return true;
            if(high!=null && high-u<=t*1L) return true;
            set.add(u);
            while (r-l>k){
                set.remove(nums[l++]*1L);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,9,1,5,9};
        boolean ans = new Solution220().containsNearbyAlmostDuplicate2(nums,2,3);
        System.out.println(ans);

        int[] nums2 = new int[]{1,0,1,1};
        boolean ans2 = new Solution220().containsNearbyAlmostDuplicate(nums2,1,2);
        System.out.println(ans2);
    }
}
