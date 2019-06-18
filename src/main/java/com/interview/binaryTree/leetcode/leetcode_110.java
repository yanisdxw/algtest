package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(Math.abs(left - right)>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;

        return Math.max(left,right);

    }

    public static void main(String[] args) {

    }
}
