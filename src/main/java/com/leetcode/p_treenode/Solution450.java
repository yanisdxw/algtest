package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val == key){
            if(root.left==null && root.right==null) return null;
            if(root.left==null && root.right!=null) return root.right;
            if(root.left!=null && root.right==null) return root.left;
            //找到root的后继节点
            TreeNode node = root.right;
            while (node.left!=null) node = node.left;
            //后继节点的值赋给root
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}
