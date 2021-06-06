package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.Stack;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 */
public class Solution897 {

    Stack<TreeNode> stack = new Stack<>();
    public TreeNode increasingBST(TreeNode root) {
        inorderTraversal(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            treeNode.left = null;
            treeNode.right = cur;
            cur = treeNode;
        }
        return cur;
    }

    private void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        stack.push(root);
        inorderTraversal(root.right);
    }
}
