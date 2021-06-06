package com.leetcode.p_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution47 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0) return ans;
        dfs(0, nums);
        return ans;
    }

    private void dfs(int pos, int[] nums){
        if(pos==nums.length){
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                path.add(nums[i]);
            }
            ans.add(path);
            return;
        }
        /**
         * DFS的特点是每一轮都在本轮可选的范围（Level至Length-1）中按顺序选一个数字，然后再进入下一轮（递归）。
         * 如果当前准备选的下标是curr，而在（Level至curr-1）中出现过相同的数字，说明该数字肯定已经选过了，
         * 再选一次铁定后续会重复。
         */
        for (int i = pos; i < nums.length; i++) {
            boolean flag=true;
            for(int k=i+1;k<nums.length;k++){  //去重
                if(nums[k]==nums[i]) flag=false;
            }
            if(flag){
                swap(i,pos,nums);
                dfs(pos+1,nums);
                swap(i,pos,nums);
            }
        }
    }



    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1};
        List<List<Integer>> ans = new Solution47().permuteUnique(nums);
        System.out.println(ans);
    }

}
