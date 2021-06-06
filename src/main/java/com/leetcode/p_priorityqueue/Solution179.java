package com.leetcode.p_priorityqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(String.valueOf(nums[i]));
        }
        String ans = "";
        while (!priorityQueue.isEmpty()){
            String top = priorityQueue.poll();
            ans = top+ans;
        }
        if(ans.charAt(0)=='0') return "0";
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        String ans = new Solution179().largestNumber(nums);
        System.out.println(ans);
    }
}
