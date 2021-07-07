package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class Solution113 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }
    private void dfs(TreeNode root, int targetSum){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.val==targetSum && root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
        }
        dfs(root.right, targetSum-root.val);
        dfs(root.left, targetSum-root.val);
        path.remove(path.size()-1);
    }
}
