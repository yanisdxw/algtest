package com.leetcode.p_divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        //使用分治理思想，遍历到某个运算符时，优先处理两边的字符串结果left[],right[]，
        //然后计算left与right的所有可能值的结果
        List<Integer> ans = new ArrayList();
        //递归终止的条件：只有纯粹的数字
        if(!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
            ans.add(Integer.valueOf(input));
        }
        int len = input.length();
        for(int i=0;i<len;i++){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> lefts = diffWaysToCompute(input.substring(0,i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1,len));
                for(Integer left:lefts){
                    for(Integer right:rights){
                        switch(c){
                            case '+': ans.add(left+right); break;
                            case '-': ans.add(left-right); break;
                            case '*': ans.add(left*right); break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        List<Integer> ans = new Solution241().diffWaysToCompute(input);
        System.out.println(ans);
    }
}
