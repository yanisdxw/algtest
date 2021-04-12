package com.leetcode.p_dp;

import java.util.Arrays;
import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0) return true;
        if(s.length()==0) return false;
        int n = s.length();
        //设dp[i]为以i为结尾的单词，在前面是否有包含于dict的词存在
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(String word:wordDict){
                int len = word.length();
                //applepen --> apple 满足条件，记录满足条件的分割点i=5,下次如果有切出来的单词（pen）符合dict，
                //如果刚好与上一个分割点（8-3=5）吻合，则产生新的分割点i=8，并记录位置。
                if(len<=i && s.substring(i-len,i).equals(word)){
                    dp[i] = dp[i]||dp[i-len];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] dict = new String[]{"leet", "code"};
        boolean ans = new Solution139().wordBreak(s, Arrays.asList(dict.clone()));
        System.out.println(ans);
        System.out.println(s.substring(0,4));
    }
}
