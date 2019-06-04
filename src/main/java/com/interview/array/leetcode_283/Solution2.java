package com.interview.array.leetcode_283;

public class Solution2 {
    public static void moveZeros(int[] nums){
        int k = 0; //nums中 [0...k)的元素均为非0
        //遍历到第i个元素后,保证[0...i]中所有非零元素
        //都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        Solution.moveZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i!=arr.length-1)
                System.out.print(",");
        }
    }
}