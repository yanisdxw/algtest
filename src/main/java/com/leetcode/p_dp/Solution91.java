package com.leetcode.p_dp;

import java.util.Arrays;

public class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        //dp[i] 为遍历到i时所能组成的最大字符组个数
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        char[] charArray = s.toCharArray();
        if(charArray[0]-'0'==0) return 0;
        for(int i=2; i<=n;i++){
            int prev = charArray[i-2]-'0';
            int cur = charArray[i-1]-'0';
            //连续2个0，直接无法编译！
            if((prev==0||prev>2)&&cur==0){
                return 0;
            }
            //主要分2大类讨论：cur与prev合并编码或不合并编码
            if(prev==1||prev==2&&cur<7){
                if(cur!=0){
                    //与前面的合并
                    dp[i] = dp[i-1] + dp[i-2];
                }else {
                    //不和前面的合并
                    dp[i] = dp[i-2];
                }
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int ans1 = new Solution91().numDecodings("0");
        System.out.println(ans1);

        int ans2 = new Solution91().numDecodings("12");
        System.out.println(ans2);

        int ans3 = new Solution91().numDecodings("226");
        System.out.println(ans3);

        int ans4 = new Solution91().numDecodings("2101");
        System.out.println(ans4);
    }
}
