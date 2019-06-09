package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right!=null){
            return minDepth(root.right)+1;
        }else if(root.right==null && root.left!=null){
            return minDepth(root.left)+1;
        }else if(root.right!=null && root.left!=null){
            return Math.min(minDepth(root.right),minDepth(root.left))+1;
        }else {
            return 1;
        }
    }
}
