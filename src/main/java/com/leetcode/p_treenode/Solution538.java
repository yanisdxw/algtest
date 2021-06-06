package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 *
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 *
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 *
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 */
public class Solution538 {
    /**
     *     //sum: 中序遍历BST得到的结果
     *     private List<Integer> vals = new LinkedList<>();
     *     private Stack<Integer> sums = new Stack<>();
     *     public TreeNode convertBST(TreeNode root) {
     *         inOrderToGet(root);
     *         System.out.println(vals);
     *         int sum = 0;
     *         for (int i = vals.size()-1; i >=0; i--) {
     *             int val = vals.get(i);
     *             sum += val;
     *             sums.add(sum);
     *         }
     *         System.out.println(sums);
     *         inOrderToPut(root);
     *         return root;
     *     }
     *
     *     private void inOrderToGet(TreeNode root){
     *         if(root==null){
     *             return;
     *         }
     *         inOrderToGet(root.left);
     *         vals.add(root.val);
     *         inOrderToGet(root.right);
     *     }
     *
     *     private void inOrderToPut(TreeNode root){
     *         if(root==null){
     *             return;
     *         }
     *         inOrderToPut(root.left);
     *         root.val = sums.pop();
     *         inOrderToPut(root.right);
     *     }
     *
     */
    private int preNum = 0;
    //递归写法
    public TreeNode convertBST(TreeNode root) {
        unPreOrder(root);
        return root;
    }
    public void unPreOrder(TreeNode root){
        if(root == null)
            return;
        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode ans = new Solution538().convertBST(root);
        List<Integer> travel = TreeNode.travel(ans);
        System.out.println(travel);
    }

}
