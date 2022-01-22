package com.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class 表达式求值 {
    private static Stack<Integer> nums = new Stack();
    private static Stack<Character> ops = new Stack();
    private static char[] pr = new char[200];
    static {
        pr['+'] = 1;
        pr['-'] = 1;
        pr['*'] = 2;
        pr['/'] = 2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)){
                int j = i; int x = 0;
                while ( j<s.length() && Character.isDigit(s.charAt(j))){
                    x = x*10 + s.charAt(j++) -'0';
                }
                i=j-1;
                nums.push(x);
            }else if(c.equals('(')){
                ops.push(c);
            }else if(c.equals(')')){
                while (!ops.peek().equals('(')) eval();
                ops.pop();
            }else {
                while (!ops.isEmpty() && !ops.peek().equals('(') && pr[ops.peek()]>=pr[c]) eval();
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval();
        System.out.print(nums.peek());
    }

    private static void eval(){
        int y = nums.pop();
        int x = nums.pop();
        char c = ops.pop();
        int res;
        if(c=='+'){
            res = x + y;
        }else if(c=='-'){
            res = x - y;
        }else if(c=='*'){
            res = x*y;
        }else {
            res = x/y;
        }
        nums.push(res);
    }
}
