package com.dxw.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void invertTree(TreeNode node) {

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);

    }

    /**栈*/
    public TreeNode invertTreeS(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    /**队列*/
    public TreeNode invertTreeQ(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
