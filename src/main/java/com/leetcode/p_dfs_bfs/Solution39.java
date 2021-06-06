package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class Solution39 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        dfs(0, candidates, target, path);
        return ans;
    }

    private void dfs(int begin, int[] nums, int target, List<Integer> path){
        //计算path中的的sum
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(path));
        }
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i,nums,target-nums[i],path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = new Solution39().combinationSum(candidates, target);
        System.out.println(ans);
    }
}
