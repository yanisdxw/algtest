package com.leetcode.p_queue;

import java.util.*;

/**
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 *
 *
 * 示例 1：
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 *
 * 输入：s = ")("
 * 输出：[""]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.equals("")){
            ans.add(s);
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> set = new HashSet<>();
        boolean isFound = false;    //判断是否找到了有效字符串
        while (!queue.isEmpty()){
            String p = queue.poll();
            if(isValid(p)){
                ans.add(p);
                isFound = true;
            }
            if(isFound){
                continue;
            }
            //以p为基础删除括号
            for (int i = 0; i < p.length(); i++) {
                //删除第i个位置的括号
                if(p.charAt(i)=='(' || p.charAt(i)==')'){
                    String q;
                    if(i==p.length()-1){
                        q = p.substring(0,p.length()-1);
                    }else {
                        q = p.substring(0,i) + p.substring(i+1);
                    }
                    if(set.add(q)){
                        queue.add(q);
                    }
                }
            }
        }
        if(ans.isEmpty()){
            ans.add("");
        }
        return ans;
    }

    private boolean isValid(String s){
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                left++;
            }else if(c==')') {
                left--;
                if(left<0){
                    return false;
                }
            }
        }
        return left==0;
    }

    public static void main(String[] args) {
        List<String> ans = new Solution301().removeInvalidParentheses("()");
        System.out.println(ans);
    }
}
