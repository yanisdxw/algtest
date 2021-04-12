package com.leetcode.p_string;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来记录【目前】该字符【缺省】的次数
        int[] count = new int[128];
        //用来记录该字符是否在t中存在
        boolean[] flag = new boolean[128];
        //先来一波t的统计，初始化两个数组
        for(int i=0;i<t.length();i++){
            count[t.charAt(i)]++;
            flag[t.charAt(i)]=true;
        }
        int cnt = 0; //目前子串中满足条件的字符个数
        int min_len = s.length()+1;//子串长度的最小值+1,如果比s还大说明没找到子串
        int l = 0; //子串左边的位置
        int l_max = 0;//子串左边位置的最小值
        int r = 0; //子串右边的位置
        for( ;r<s.length(); r++){
            //右边界向右遍历，找到了包含t的字符就更新一下两个数组
            if(flag[s.charAt(r)]){
                if(--count[s.charAt(r)]>=0){
                    cnt++;
                }
            }
            while(cnt==t.length()){
                if(r-l+1<min_len){
                    min_len = r-l+1;
                    l_max = l;
                }
                //左边界向右遍历，如果丢失了t字符还是要更新数组
                if(flag[s.charAt(l)] && ++count[s.charAt(l)]>0){
                    cnt--;
                }
                l++;
            }
        }
        return min_len>s.length()?"":s.substring(l_max, l_max+min_len);
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        String solution = new Solution76().minWindow(a,b);
        System.out.println(solution);
        //System.out.println("ab".substring(2,3));
    }
}
