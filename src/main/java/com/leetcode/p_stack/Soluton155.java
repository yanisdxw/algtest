package com.leetcode.p_stack;

import java.util.Stack;

public class Soluton155 {

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 辅助min_stack永远保证栈顶为最小值
         */

        public void push(int x) {
            stack.push(x);
            if(!minStack.isEmpty()){
                if(x<=minStack.peek()){
                    minStack.push(x);
                }
            }else {
                minStack.push(x);
            }
        }

        public void pop() {
            int top = stack.pop();
            if(top==minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
