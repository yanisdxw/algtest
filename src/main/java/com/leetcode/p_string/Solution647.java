package com.leetcode.p_string;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class Solution647 {

    /***
     *     public int countSubstrings(String s) {
     *         if(s==null||s.length()==0) return 0;
     *         int i = 0;
     *         int ans = 0;
     *         while (i<s.length()-1){
     *             ans+=countSubstringsOdd(s,i);
     *             ans+=countSubstringsEven(s,i);
     *             i++;
     *         }
     *         return ans;
     *     }
     *
     *     //记录以i为中心的回文串个数(奇数)
     *     public int countSubstringsOdd(String s, int i){
     *         int left = i-1;
     *         int right = i+1;
     *         int count = 1;
     *         while (left>=0&&right<=s.length()-1){
     *             if(s.charAt(left)==s.charAt(right)){
     *                 count++;
     *             }else {
     *                 break;
     *             }
     *             left--;
     *             right++;
     *         }
     *         return count;
     *     }
     *
     *     //记录以i为中心的回文串个数(偶数)
     *     public int countSubstringsEven(String s, int i){
     *         int left = i;
     *         int right = i+1;
     *         int count = 0;
     *         while (left>=0&&right<=s.length()-1){
     *             if(s.charAt(left)==s.charAt(right)){
     *                 count++;
     *             }else {
     *                 break;
     *             }
     *             left--;
     *             right++;
     *         }
     *         return count;
     *     }
     *
     */

    public int countSubstrings(String s) {
        if(s==null||s.length()==0) return 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文长度奇数
            ans += countSubstrings(s,i,i);
            // 回文偶数
            ans += countSubstrings(s,i,i+1);
        }
        return ans;
    }


    public int countSubstrings(String s, int l, int r){
        int count = 0;
        while (l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int ans = new Solution647().countSubstrings(s);
        System.out.println(ans);
    }
}
