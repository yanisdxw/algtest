package com.leetcode.p_stack;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                /**
                 * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                 * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                 */
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    ans = Math.max(ans, i-stack.peek());
                }
            }
        }
        return ans;
    }

//    public int longestValidParentheses2(String s){
//        Stack<Character> stack = new Stack<>();
//        int ans = 0;
//        int cur = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if(stack.isEmpty()){
//                stack.push(c);
//            }else {
//                Character top = stack.peek();
//                if(c==')'&&top=='('){
//                    stack.pop();
//                    cur += 2;
//                    ans = Math.max(cur, ans);
//                }else if(c=='('&&top=='('){
//                    stack.push(c);
//                }else {
//                    cur = 0;
//                    stack.push(c);
//                }
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        String s = "(()()()()((()))";
        int ans = new Solution32().longestValidParentheses(s);
        System.out.println(ans);
    }
}
