package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_101 {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    public static void main(String[] args) {

    }
}
