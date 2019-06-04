package com.interview.array.leetcode_75;

public class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0,0,0};
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i]>=0 && nums[i]<=2);
            count[nums[i]]++;
        }

        int index=0;

        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {

    }
}
