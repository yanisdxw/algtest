package com.leetcode.p_other;

import com.leetcode.Utils;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        //找到第一个非降序的数
        if(nums.length==1) return;
        //倒序遍历数组
        for (int i = nums.length-1; i>=0; i--) {
            if(i==nums.length-1) continue;
            if(nums[i]<nums[i+1]){
                //nums[i]是第一个非降序的数
                for (int j = nums.length-1; j>=0 ; j--) {
                    //找到一个个比nums[i]大的数，交换
                    if(nums[j]>nums[i]){
                        swap(i,j,nums);
                        //翻转i后面的数
                        reverse(i+1,nums.length-1,nums);
                        return;
                    }
                }
            }
        }
        //如果没找到第一个非倒序排列的数，直接翻转
        reverse(0,nums.length-1,nums);
    }

    //翻转数组
    public void reverse(int i, int j, int[] nums){
        if(i<0 || j>=nums.length) return;
        while (i<j){
            swap(i++,j--,nums);
        }
    }

    //交换
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,1};
        new Solution31().nextPermutation(input);
        Utils.printArray(input);
    }
}
