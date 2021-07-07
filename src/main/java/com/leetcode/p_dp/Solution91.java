package com.leetcode.p_dp;

import java.util.Arrays;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 */
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
                    //可以不与前面的合并
                    dp[i] = dp[i-1] + dp[i-2];
                }else {
                    //必须和前面的合并
                    dp[i] = dp[i-2];
                }
            }else { //一定不能和前面的合并
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
