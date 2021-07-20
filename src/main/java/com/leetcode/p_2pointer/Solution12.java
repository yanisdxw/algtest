package com.leetcode.p_2pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class Solution12 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = -1*nums[i];
            int left = i+1; int right = nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]<target){
                    left++;
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[left]);
                    res.add(nums[right]);
                    res.add(nums[i]);
                    ans.add(res);
                    //// 现在要增加 left，减小 right，但是不能重复
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{-2,0,0,2,2};
        List<List<Integer>> ans = new Solution12().threeSum(nums);
        System.out.println(ans);
    }

}
