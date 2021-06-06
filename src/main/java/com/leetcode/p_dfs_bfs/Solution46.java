package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.Utils.toArrayStr;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null||nums.length==0) return ans;
        dfs(nums, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, int level, List<List<Integer>> ans){
        if(level==nums.length-1){
            //走到底了（数组最后一个值），此时记录数组模样
            List<Integer> local = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                local.add(nums[i]);
            }
            ans.add(local);
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            dfs(nums, level+1, ans);
            //恢复现场（回溯）
            swap(nums, level, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        System.out.println("before:数组为"+toArrayStr(nums)+",要交换"+nums[i]+"和"+nums[j]);
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        System.out.println("after:数组为"+toArrayStr(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = new Solution46().permute(nums);
        System.out.println(ans);
    }
}
