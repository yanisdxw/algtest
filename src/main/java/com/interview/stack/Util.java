package com.interview.stack;

import java.util.Stack;

public class Util {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.isEmpty()){
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if( c == ')' && !stack.isEmpty()){
                Character top = stack.peek();
                if(top != '('){
                    return false;
                }else {
                    stack.pop();
                }
            }else if( c == ']' && !stack.isEmpty()){
                Character top = stack.peek();
                if(top!='['){
                    return false;
                }else {
                    stack.pop();
                }
            }else if( c == '}' && !stack.isEmpty()){
                Character top = stack.peek();
                if(top!='{'){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }
        }

        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "{[]}";
        boolean res = isValid(s);
        System.out.println(res);
    }
}
