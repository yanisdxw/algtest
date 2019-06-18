package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {

    }
}
