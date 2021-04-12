package com.leetcode.p_stack;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s){
                case "+": {
                    Integer s1 = stack.pop();
                    Integer s2 = stack.pop();
                    Integer res = s1 + s2;
                    stack.push(res);
                } break;
                case "-": {
                    Integer s1 = stack.pop();
                    Integer s2 = stack.pop();
                    Integer res = s2 - s1;
                    stack.push(res);
                } break;
                case "*": {
                    Integer s1 = stack.pop();
                    Integer s2 = stack.pop();
                    Integer res = s1*s2;
                    stack.push(res);
                } break;
                case "/":{
                    Integer s1 = stack.pop();
                    Integer s2 = stack.pop();
                    Integer res = s2/s1;
                    stack.push(res);
                } break;
                default: stack.push(Integer.parseInt(s)); break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ans = new Solution150().evalRPN(tokens);
        System.out.println(ans);
    }
}
