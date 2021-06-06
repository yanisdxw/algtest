package com.leetcode.p_array;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 */
public class Solution581 {

    //无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int high = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i]<max){
                high = i;
            }
        }
        int low = nums.length-1;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i]>min){
                low = i;
            }
        }
        return low<high?high-low+1:0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        int ans = new Solution581().findUnsortedSubarray(nums);
        System.out.println(ans);
    }
}
