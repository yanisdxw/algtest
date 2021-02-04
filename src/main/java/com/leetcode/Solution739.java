package com.leetcode;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        //栈顶始终保持最高的气温的日期，栈（代表的气温）为从大到小的单调栈
        Stack<Integer> stack = new Stack();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()){
                int top = stack.peek();
                if(T[top]>=T[i]){
                    break;
                }
                stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }
        return ans;
    }
}
