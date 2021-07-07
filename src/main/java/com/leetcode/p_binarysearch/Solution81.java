package com.leetcode.p_binarysearch;

/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int l = 0; int r = nums.length -1;
        int mid;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]==target){
                return true;
            } else if(nums[mid]>nums[l]){
                //左边是有序的
                if(target<nums[mid]&&target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            } else if(nums[mid]<nums[l]){
                //右边是有序的
                if(target>nums[mid]&&target<=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            } else {
                // nums[mid] == nums[i]: 无法判断左右哪边有序
                l++;
            }
        }
        return false;
    }
}
