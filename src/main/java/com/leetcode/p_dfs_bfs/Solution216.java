package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution216 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k==0 || n==0){
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        dfs(k,n,1,path);
        return ans;
    }

    private void dfs(int k, int target, int pos, List<Integer> path){
        if(path.size()>k){
            return;
        }
        if(target==0 && path.size()==k){
            ans.add(new ArrayList<>(path));
        }
        for (int i = pos; i < 10; i++) {
            path.add(i);
            dfs(k,target-i,i+1,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        List<List<Integer>> ans = new Solution216().combinationSum3(k,n);
        System.out.println(ans);
    }
}
