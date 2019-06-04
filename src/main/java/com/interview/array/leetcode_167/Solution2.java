package com.interview.array.leetcode_167;

import com.interview.array.Util;

//对撞指针
public class Solution2 {
    public static int[] twoSum(int[] numbers, int target) {

        if(numbers.length < 2 /*|| !isSorted(numbers)*/)
            throw new IllegalArgumentException("Illegal argument numbers");

        int l = 0, r = numbers.length-1;
        while (l < r){
            if(numbers[l]+numbers[r]==target){
                int[] res = new int[]{l+1,r+1};
                return res;
            }else if(numbers[l]+numbers[r]<target){
                l++;
            }else {
                r--;
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,9,56,90};
        int[] res = twoSum(nums,8);
        Util.printArray(res);
    }
}
