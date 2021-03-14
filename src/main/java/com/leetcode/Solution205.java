package com.leetcode;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] s_char = new int[256];
        int[] t_char = new int[256];
        //记录s与t中各个字符第一次出现的位置
        for (int i = 0; i < s.length(); i++) {
            if(s_char[s.charAt(i)]!=t_char[t.charAt(i)]){
                return false;
            }
            s_char[s.charAt(i)] = t_char[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
