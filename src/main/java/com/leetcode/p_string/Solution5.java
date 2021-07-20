package com.leetcode.p_string;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        // 数组第一位记录起始位置，第二位记录长度
        int[] ans = new int[]{0,0};
        for (int i = 0; i < s.length()-1; i++) {
            int[] odd = centerSpread(s,i,i);
            int[] even = centerSpread(s,i,i+1);
            int[] max = odd[1]>even[1]?odd:even;
            if(max[1]>ans[1]){
                ans = max;
            }
        }
        return s.substring(ans[0],ans[0]+ans[1]);
    }

    //第一个表示位置，第二个表示长度
    private int[] centerSpread(String s, int l, int r){
        while (l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }else {
                break;
            }
        }
        return new int[]{l+1,r-l-1};
    }

    public static void main(String[] args) {
        String ans = new Solution5().longestPalindrome("babad");
        System.out.println(ans);
    }
}
