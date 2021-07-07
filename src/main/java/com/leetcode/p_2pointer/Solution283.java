package com.leetcode.p_2pointer;

import com.leetcode.Utils;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        //p指向非0数真正应该插入的位置
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                swap(nums,p++,i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new Solution283().moveZeroes(nums);
        Utils.printArray(nums);
    }
}
