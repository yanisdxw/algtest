package com.leetcode.p_string;

public class Solution647 {

    public int countSubstrings(String s) {
        if(s==null||s.length()==0) return 0;
        int i = 0;
        int ans = 0;
        while (i<s.length()){
            ans+=countSubstringsOdd(s,i);
            ans+=countSubstringsEven(s,i);
            i++;
        }
        return ans;
    }

    //记录以i为中心的回文串个数(奇数)
    public int countSubstringsOdd(String s, int i){
        int left = i-1;
        int right = i+1;
        int count = 1;
        while (left>=0&&right<=s.length()-1){
            if(s.charAt(left)==s.charAt(right)){
                count++;
            }else {
                break;
            }
            left--;
            right++;
        }
        return count;
    }

    //记录以i为中心的回文串个数(偶数)
    public int countSubstringsEven(String s, int i){
        int left = i;
        int right = i+1;
        int count = 0;
        while (left>=0&&right<=s.length()-1){
            if(s.charAt(left)==s.charAt(right)){
                count++;
            }else {
                break;
            }
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "fdsklf";
        int ans = new Solution647().countSubstrings(s);
        System.out.println(ans);
    }
}
