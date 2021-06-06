package com.leetcode.p_array;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Solution169 {
    //排序

    /**
     *    public int majorityElement(int[] nums) {
     *         if(nums.length==1){
     *             return nums[0];
     *         }
     *         Arrays.sort(nums);
     *         return nums[nums.length/2];
     *     }
     */
    //摩尔投票法
//    玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。
//    最后还有人活下来的国家就是胜利。
//    那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），
//    或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
//    最后能剩下的必定是自己人。
    public int majorityElement(int[] nums){
        int count = 1;
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(ret==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    count=1;
                    ret = nums[i];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        int ans = new Solution169().majorityElement(nums);
        System.out.println(ans);
    }
}
