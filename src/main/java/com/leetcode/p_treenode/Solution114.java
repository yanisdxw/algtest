package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 */
public class Solution114 {
    Stack<TreeNode> stack;
    public void flatten(TreeNode root) {
        stack = new Stack<>();
        preOrderTravel(root);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            cur.right = pre;
            cur.left = null;
            pre = cur;
        }
    }

    private void preOrderTravel(TreeNode root){
        if(root==null){
            return;
        }
        stack.push(root);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    //o(1)空间
    TreeNode pre = null;
    public void flatten2(TreeNode root){
        if(root==null){
            return;
        }
        flatten2(root.right); // 此时 root的左子树 已经被 拉成一条 往右下延申的链表
        flatten2(root.left); // 此时 root的右子树 已经被 拉成一条 往右下延申的链表
        // 接下来 把左子树 的链表 插入到 根节点 和 右子树链表的中间， 即可
        root.left = null;
        root.right = pre;
        pre = root;
    }


}
