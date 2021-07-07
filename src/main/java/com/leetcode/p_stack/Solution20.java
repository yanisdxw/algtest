package com.leetcode.p_stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 */
public class Solution20 {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(c=='('||c=='['||c=='{'){
//                stack.push(c);
//            }else {
//                if(stack.isEmpty()){
//                    return false;
//                }
//                char top = stack.peek();
//                switch (c){
//                    case ')': {
//                        if(top=='(') {
//                            stack.pop();
//                        }else {
//                            return false;
//                        }
//                    } break;
//                    case ']':{
//                        if(top=='[') {
//                            stack.pop();
//                        }else {
//                            return false;
//                        }
//                    } break;
//                    case '}':{
//                        if(top=='{') {
//                            stack.pop();
//                        }else {
//                            return false;
//                        }
//                    } break;
//                    default: break;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }
}
