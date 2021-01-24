package com.leetcode;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int l = 0; int r = nums.length -1;
        int mid;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]==nums[l]){
                //无法判断是哪个区间
                l++;
            }else if(nums[mid]<=nums[r]){
                //右边是有序的
                if(target>nums[mid]&&target<=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else {
                //左边是有序的
                if(target<nums[mid]&&target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
