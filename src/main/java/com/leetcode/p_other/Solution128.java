package com.leetcode.p_other;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size()==1) return 1;
        Iterator<Integer> iterator = set.iterator();
        int ans = 0;
        int local_len = 1;
        int prev = iterator.next();
        while (iterator.hasNext()){
            int cur = iterator.next();
            if(cur==prev+1){
                local_len++;
            }else {
                local_len=1;
            }
            prev = cur;
            ans = Math.max(ans,local_len);
        }
        return ans;
    }
}
