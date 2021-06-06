package com.leetcode.bitwise;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution136 {

    //使用常规思路

    /**
     *    public int singleNumber(int[] nums) {
     *         Map<Integer,Integer> map = new HashMap<>();
     *         for (int i = 0; i < nums.length; i++) {
     *             if(map.containsKey(nums[i])){
     *                 map.put(nums[i],map.get(nums[i])+1);
     *             }else {
     *                 map.put(nums[i],1);
     *             }
     *         }
     *         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
     *             if(entry.getValue()<2){
     *                 return entry.getKey();
     *             }
     *         }
     *         return -1;
     *     }
     */

    //位运算
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int ans = new Solution136().singleNumber(nums);
        System.out.println(ans);
    }
}
