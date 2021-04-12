package com.leetcode.p_binarysearch;

import com.leetcode.p_binarysearch.Solution153;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5]
 * 输出：1
 */
public class Solution154 {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int l = 0;
        int r = nums.length-1;
        //当r==l,循环停止
        //因为我们要遍历到l==r，所以这里有开区间写法
        while (l<r){
            int mid = l + (r-l)/2;
            //判断的依据：mid在最小值的左侧还是右侧
            if(nums[mid]==nums[r]){
                r--;
            }else if(nums[mid]<nums[r]){
                //最小值在mid左侧
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,5,6,7,0,1,2};
        int ans = new Solution153().findMin(nums);
        System.out.println(ans);
        int[] nums2 = new int[]{3,4,5,1,2};
        int ans2 = new Solution153().findMin(nums2);
        System.out.println(ans2);
        int[] nums3 = new int[]{11,13,15,17};
        int ans3 = new Solution153().findMin(nums3);
        System.out.println(ans3);

        int[] nums4 = new int[]{1,1,2,1};
        int ans4 = new Solution153().findMin(nums4);
        System.out.println(ans4);

        int[] nums5 = new int[]{3,1,2};
        int ans5 = new Solution153().findMin(nums5);
        System.out.println(ans5);

        int[] nums6 = new int[]{5,1,2,3,4};
        int ans6 = new Solution153().findMin(nums6);
        System.out.println(ans6);
    }
}
