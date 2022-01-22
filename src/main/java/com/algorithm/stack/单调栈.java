package com.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acwing.com/problem/content/832/
 */
public class 单调栈 {
//    输入样例：
//            5
//            3 4 2 7 5
//    输出样例：
//            -1 3 -1 2 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            while (!stack.isEmpty() && stack.peek()>=x){
                stack.pop();
            }
            if(stack.isEmpty()) {
                System.out.print("-1 ");
            }else {
                System.out.print(stack.peek()+" ");
            }
            stack.push(x);
        }
    }
}
