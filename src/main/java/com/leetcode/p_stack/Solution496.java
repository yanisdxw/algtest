package com.leetcode.p_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Map<Integer,Integer> map = nextGreaterNum(nums2);
       int[] ans = new int[nums1.length];
       for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i],-1);
       }
        return ans;
    }

    private Map<Integer,Integer> nextGreaterNum(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                stack.pop();
            }
            Integer nextGreaterNum = stack.isEmpty()?-1:stack.peek();
            map.put(nums[i], nextGreaterNum);
            stack.push(nums[i]);
        }
        return map;
    }

    private Map<Integer,Integer> nextGreaterNum2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                map.put(nums[stack.pop()],nums[i]);
            }
            stack.push(i);
        }
        return map;
    }

    /** 单调栈模板[右往左]
     *     private int[] nextGreaterNum(int[] nums){
     *         int[] ans = new int[nums.length];
     *         Stack<Integer> stack = new Stack<>();
     *         for (int i = nums.length-1; i >=0 ; i--) {
     *             while (!stack.isEmpty() && nums[i]>stack.peek()){
     *                 stack.pop();
     *             }
     *             ans[i] = stack.isEmpty()?-1:stack.peek();
     *             stack.push(nums[i]);
     *         }
     *         return ans;
     *     }
     */

    /** 单调栈模板[左往右]
     *    private Map<Integer,Integer> nextGreaterNum(int[] nums){
     *         Map<Integer,Integer> map = new HashMap<>();
     *         Stack<Integer> stack = new Stack<>();
     *         for (int i = 0; i < nums.length; i++) {
     *             while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
     *                 map.put(nums[stack.pop()],nums[i]);
     *             }
     *             stack.push(i);
     *         }
     *         return map;
     *     }
     */

    public static void main(String[] args) {

    }
}
