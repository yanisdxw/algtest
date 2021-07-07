package com.leetcode.p_binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int low = lower_bound(nums, target);
        int up = upper_bound(nums, target)-1;
        if(low==nums.length || nums[low]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{low, up};
    }

    //类c++ low_bound函数，作用是找出nums中第一次出现target的位置
    public int lower_bound(int[] nums, int target){
        int l = 0; int r = nums.length-1; int mid;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]>=target){
                //即使相等，右边界依然向中间收敛-->对大数值范围更加苛刻以找到最小值
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;
    }
    //类c++ upper函数，作用是找到nums中第一个大于target的位置
    public int upper_bound(int[] nums, int target){
        int l = 0; int r = nums.length-1; int mid;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]<=target){
                //即使相等，左边界依然向中间收敛-->对小数值范围更加苛刻以找到最大值
                l = mid +1;
            }else{
                r = mid -1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

    }
}
