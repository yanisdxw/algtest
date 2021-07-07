package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.Utils.toArrayStr;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Solution46 {

    /**
     *     public List<List<Integer>> permute(int[] nums) {
     *         List<List<Integer>> ans = new ArrayList<>();
     *         if(nums==null||nums.length==0) return ans;
     *         dfs(nums, 0, ans);
     *         return ans;
     *     }
     *
     *     private void dfs(int[] nums, int level, List<List<Integer>> ans){
     *         if(level==nums.length-1){
     *             //走到底了（数组最后一个值），此时记录数组模样
     *             List<Integer> local = new ArrayList<>();
     *             for(int i=0;i<nums.length;i++){
     *                 local.add(nums[i]);
     *             }
     *             ans.add(local);
     *         }
     *         for (int i = level; i < nums.length; i++) {
     *             swap(nums, level, i);
     *             dfs(nums, level+1, ans);
     *             //恢复现场（回溯）
     *             swap(nums, level, i);
     *         }
     *     }
     *
     *      private void swap(int[] nums, int i, int j){
     *         System.out.println("before:数组为"+toArrayStr(nums)+",要交换"+nums[i]+"和"+nums[j]);
     *         int tmp = nums[i];
     *         nums[i] = nums[j];
     *         nums[j] = tmp;
     *         System.out.println("after:数组为"+toArrayStr(nums));
     *     }
     */
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        List<Integer> path = new ArrayList<>();
        if(nums==null||nums.length==0) return ans;
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used);
        return ans;
    }

    private void dfs(int[] nums, int pos, List<Integer> path, boolean[] used){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,i+1,path,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = new Solution46().permute(nums);
        System.out.println(ans);
    }
}
