package com.interview.array.leetcode_3;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int ans = 0;
        int n = s.length();
        HashSet<Character> hashSet = new HashSet<>();
        while(i<n && j<n){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else{
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
