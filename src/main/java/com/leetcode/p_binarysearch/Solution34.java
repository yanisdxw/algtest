package com.leetcode.p_binarysearch;

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
