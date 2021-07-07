package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        //深度优先遍历，ans存储所有遍历的元素
        dfs(nums,0,path);
        return ans;
    }

    //遍历获取所有包含num[pos]的数组并放入ans中
    private void dfs(int[] nums, int pos, List<Integer> path){
        ans.add(new ArrayList<Integer>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums,i+1, path);
            path.remove(path.size()-1);
        }
    }
}
