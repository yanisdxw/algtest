package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }else{
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
