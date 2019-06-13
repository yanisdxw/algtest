package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode minNode, TreeNode maxNode){
        if(node == null){
            return true;
        }

        if( minNode!=null && node.val <= minNode.val || maxNode!=null && node.val >= maxNode.val){
            return false;
        }
        //左边不能超过最大值 右边不能小于最小值
        //所以左孩子的minNode不变, maxNode更新为父节点
        //右孩子的maxNode不变,minNode更新为父节点
        return isValidBST(node.left, minNode, node) && isValidBST(node.right, node, maxNode);
    }

    public static void main(String[] args) {

    }
}
