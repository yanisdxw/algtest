package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class Solution40 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0){
            return ans;
        }
        Arrays.sort(candidates);
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
            if(i>begin && nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(i+1,nums,target-nums[i],path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new Solution40().combinationSum2(candidates, target);
        System.out.println(ans);
    }
}
