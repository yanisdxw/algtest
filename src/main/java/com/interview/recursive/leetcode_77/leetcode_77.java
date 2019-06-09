package com.interview.recursive.leetcode_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_77 {

    private List<List<Integer>> res;
    //只需要考虑start之后的数字,当前已经找到的组合存在c中
    private void generateCobination(int n, int k, int start, LinkedList<Integer> c){
        if(c.size()==k){
            res.add(new LinkedList<>(c));
            return;
        }
        // 还有 k-c.size()个空位 所以[i..n]中至少要有k-c.size()个元素
        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCobination(n,k,i+1,c);
            c.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n<=0 || k<=0 || k>n){
            return res;
        }
        LinkedList<Integer> c = new LinkedList<>();
        generateCobination(n,k,1,c);
        return res;
    }
}
