package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution77 {

    /**
     *     public List<List<Integer>> combine(int n, int k) {
     *         List<List<Integer>> ans = new ArrayList<>();//最终结果
     *         int[] comb = new int[k];//当前组合
     *         int count = 0;//当前组合有多少数字
     *         dfs(ans, comb, count, 1, n, k);
     *         return ans;
     *     }
     *
     *     private void dfs(List<List<Integer>> ans, int[] comb, int count, int pos, int n, int k){
     *         if(count==k){
     *             List<Integer> res = new ArrayList<>();
     *             for (int i = 0; i < count; i++) {
     *                 res.add(comb[i]);
     *             }
     *             ans.add(res);
     *             return;
     *         }
     *         for (int i = pos; i <= n; i++) {
     *             comb[count++] = i;
     *             dfs(ans, comb, count, i+1, n, k);
     *             count--;
     *         }
     *     }
     */
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        dfs(1, path, n, k);
        return ans;
    }

    private void dfs(int pos, List<Integer> path, int n, int k){
        if(path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            dfs(i+1,path,n,k);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution77().combine(3,2);
        System.out.println(ans);
    }
}
