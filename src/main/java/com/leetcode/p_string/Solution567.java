package com.leetcode.p_string;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        boolean[] exist = new boolean[128];
        int[] freq = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            exist[s1.charAt(i)] = true;
            freq[s1.charAt(i)]++;
        }
        int l = 0; int r = 0; int cnt = 0;
        while (r<s2.length()){
            char c = s2.charAt(r);
            if(exist[c]){
                if(--freq[c]>=0){
                    cnt++;
                }
            }
            while (cnt==s1.length()){
                if(r-l+1==s1.length()){
                    return true;
                }
                if(exist[s2.charAt(l)]){
                    if(++freq[s2.charAt(l)]>0){
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2= "eidboaoo";
//        boolean ans = new Solution567().checkInclusion(s1,s2);
//        System.out.println(ans);
//        s1 = "ab";
//        s2 = "eidbaooo";
//        ans = new Solution567().checkInclusion(s1,s2);
//        System.out.println(ans);
        String s1 = "adc";
        String s2 = "dcda";
        boolean ans = new Solution567().checkInclusion(s1,s2);
        System.out.println(ans);
    }
}
