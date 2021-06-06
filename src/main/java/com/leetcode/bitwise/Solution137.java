package com.leetcode.bitwise;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class Solution137 {

    public int singleNumber(int[] nums) {
        //用一个32位数组记录各个位数出现了几次
        int[] cnt = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                cnt[j] += nums[i]&1; //记录第j位出现了几次
                nums[i]>>>=1;//移位
            }
        }
        int ans = 0; int m = 3;
        for (int i = 0; i < 32; i++) {
            ans<<=1; //左移一位
            ans|=cnt[31-i]%m; //恢复第i位的值
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
