package com.leetcode.p_stack;

import java.util.Stack;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
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

    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        //栈顶始终保持最高的气温的日期，栈（代表的气温）为从大到小的单调栈
        Stack<Integer> stack = new Stack();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }

}
