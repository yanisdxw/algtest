package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        max = Math.max(max, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {

    }

}
