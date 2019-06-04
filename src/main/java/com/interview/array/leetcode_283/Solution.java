package com.interview.array.leetcode_283;

import java.util.ArrayList;
import java.util.Vector;

public class Solution {

    public static void moveZeros(int[] nums){
//        int[] newNum = new int[nums.length];
        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nonZeroElements.add(nums[i]);
            }
        }
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < nums.length; i++) {
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
