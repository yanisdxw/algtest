package com.leetcode.p_string;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 */
public class Solution3 {

    /**
     *    public int lengthOfLongestSubstring(String s) {
     *         if(s.length()==0) {
     *             return 0;
     *         }
     *         if(s.length()==1) {
     *             return 1;
     *         }
     *         Set<Character> set = new HashSet();
     *         int res = 1;
     *         for(int i=0;i<s.length();i++){
     *             //包含s[i]的最长串
     *             Character p = s.charAt(i);
     *             set.add(p);
     *             for(int j=i+1;j<s.length();j++){
     *                 Character q = s.charAt(j);
     *                 if(set.contains(q)){
     *                     set.clear();
     *                     break;
     *                 }else{
     *                     set.add(q);
     *                     res = Math.max(res, set.size());
     *                 }
     *             }
     *         }
     *         return res;
     *     }
     */

    public int lengthOfLongestSubstring(String s){
        int len = s.length();
        int left = 0; int right = 0;
        int[] count = new int[128];
        int max = 0;
        while (right<len){
            char c = s.charAt(right);
            count[c]++;
            while (count[c]>1){
                count[s.charAt(left++)]--;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        int res = new Solution3().lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
}
