package com.interview.array.leetcode_125;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==""){
            return true;
        }
        String str = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while (l<r){
            if (!isValidChar(str.charAt(l))){
                l++;
                continue;
            }
            if (!isValidChar(str.charAt(r))){
                r--;
                continue;
            }
            if(str.charAt(l)==str.charAt(r)){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean isValidChar(char c){
        if((48 <= (int)c && (int)c <= 57)||((int)c>=97 && (int)c<=122)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
