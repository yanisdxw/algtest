package com.leetcode.p_binarysearch;

public class BaseTemplate {

    //左闭右开
    public int binarySearch1(int[] nums, int target){
        int l = 0;
        int r = nums.length;
        while (l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }


    //左闭右闭
    public int binarySearch2(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
