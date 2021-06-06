package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    private void inorderTraversal(TreeNode node, List<Integer> ans){
        if(node==null){
            return;
        }
        inorderTraversal(node.left, ans);
        ans.add(node.val);
        inorderTraversal(node.right,ans);
    }

    //非递归写法
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur= root;
        while (cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                //遍历完左节点后才记录中间节点
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> ans1 = new Solution94().inorderTraversal(root);
        System.out.println(ans1);
        List<Integer> ans2 = new Solution94().inorderTraversal2(root);
        System.out.println(ans2);
    }
}
