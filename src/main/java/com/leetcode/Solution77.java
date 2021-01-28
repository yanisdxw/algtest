package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();//最终结果
        int[] comb = new int[k];//当前组合
        int count = 0;//当前组合有多少数字
        dfs(ans, comb, count, 1, n, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] comb, int count, int pos, int n, int k){
        if(count==k){
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                res.add(comb[i]);
            }
            ans.add(res);
            return;
        }
        for (int i = pos; i <= n; i++) {
            comb[count++] = i;
            dfs(ans, comb, count, i+1, n, k);
            count--;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution77().combine(3,2);
        System.out.println(ans);
    }
}
