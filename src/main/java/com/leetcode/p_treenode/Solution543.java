package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Solution543 {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        depth(root);
        return ans;
    }

    private int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(left+right, ans);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        int ans = new Solution543().diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}
