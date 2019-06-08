package com.interview.recursive.leetcode_226;

import com.interview.stack.TreeNode;

public class leetcode_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        swap(root, root.left,root.right);

        return root;
    }


    private void swap(TreeNode root, TreeNode left, TreeNode right){
        root.left = right;
        root.right = left;
    }
}
