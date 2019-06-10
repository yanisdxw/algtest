package com.interview.greedy.leetcode;

public class leetcode_392 {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")){
            return true;
        }
        if(t.equals("")){
            return false;
        }
        int index = 0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(index)==t.charAt(i)){
                index++;
                if(index==s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
