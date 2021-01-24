package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {
            return 0;
        }
        if(s.length()==1) {
            return 1;
        }
        Set<Character> set = new HashSet();
        int res = 1;
        for(int i=0;i<s.length();i++){
            //包含s[i]的最长串
            Character p = s.charAt(i);
            set.add(p);
            for(int j=i+1;j<s.length();j++){
                Character q = s.charAt(j);
                if(set.contains(q)){
                    set.clear();
                    break;
                }else{
                    set.add(q);
                    res = Math.max(res, set.size());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution3().lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
}
