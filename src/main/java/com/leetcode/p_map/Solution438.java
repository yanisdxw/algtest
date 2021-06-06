package com.leetcode.p_map;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[] pfreq = new int[26];
        int[] sfreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pfreq[p.charAt(i)-'a']++;
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right)-'a';
            sfreq[curRight]++;
            while (sfreq[curRight]>pfreq[curRight]){
                int curLeft = s.charAt(left)-'a';
                sfreq[curLeft]--;
                left++;
            }
            if(right-left+1==p.length()){
                ans.add(left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = new Solution438().findAnagrams("abab","ab");
        System.out.println(ans);
    }
}
