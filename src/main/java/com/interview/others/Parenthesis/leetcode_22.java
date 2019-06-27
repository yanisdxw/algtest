package com.interview.others.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        gen(n,0,0,"");
        return res;
    }

    private void gen(int n, int left, int right, String result){
        if(left==n && right==n) {
            res.add(result);
            return;
        }
        if(left<n){
            gen(n,left+1,right,result+"(");
        }
        if(right<n && right<left){
            gen(n,left,right+1,result+")");
        }
    }
}
