package com.leetcode.p_math;

public class Solution504 {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        boolean nega = num<0;
        if(nega) num = -num;
        int b=0; String ans = "";
        while(num!=0){
            b = num%7;
            num = num/7;
            ans = b+ans;
        }
        return nega?"-"+ans:ans;
    }

    public static void main(String[] args) {
        String ans = new Solution504().convertToBase7(7);
        System.out.println(ans);
    }
}
