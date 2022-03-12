package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

public class Solution110 {
    private boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int lh = dfs(root.left); int rh = dfs(root.right);
        if(Math.abs(lh-rh)>1) ans = false;
        return Math.max(lh,rh)+1;
    }
//    public boolean isBalanced(TreeNode root) {
//        if(root==null) return true;
//        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int maxDepth(TreeNode root){
//        if(root==null) return 0;
//        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//    }
}
