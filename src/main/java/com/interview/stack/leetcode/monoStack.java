package com.interview.stack.leetcode;

import java.util.Stack;

public class monoStack {

    public static int[] findMaxRightWithStack(int[] array) {
        if(array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        //单调递增栈
        while(index < size) {
            //栈非空并且栈顶元素小于等于入栈元素
            if(!stack.isEmpty() && array[index] > array[stack.peek()]) {
                //栈顶元素出栈;
                //更新结果;
                result[stack.pop()] = array[index];
            }else{
                //栈为空或入栈元素大于等于栈顶元素,入栈
                stack.push(index);
                index++;
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 5, 4, 3, 9, 7, 2, 5};
        int[] res = findMaxRightWithStack(arr);
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if(i!=res.length-1)
                System.out.print(",");
        }
        System.out.print("]");
    }

}
