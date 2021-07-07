package com.leetcode.p_dp;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
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
            System.out.println("dp["+i+"]="+dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {

        String s = "leetcode";

        System.out.println(s+ " sub[0,1]="+s.substring(0,1));

        String[] dict = new String[]{"leet", "code"};
        boolean ans = new Solution139().wordBreak(s, Arrays.asList(dict.clone()));
        System.out.println(ans);
        System.out.println(s.substring(0,4));
    }
}
