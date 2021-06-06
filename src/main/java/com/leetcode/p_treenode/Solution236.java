package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -10^9 <= Node.val <= 10^9
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Solution236 {
    //先遍历二叉树，记录每个节点的父节点（邻接表），然后分别得到2个节点值到根的路径，
    //找到路径上最第一个相同的值
    Map<Integer,TreeNode> joint = new HashMap<>();

    /**
     *    //递归算法
     *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     *         // LCA 问题
     *         if (root == null) {
     *             return root;
     *         }
     *         if (root == p || root == q) {
     *             return root;
     *         }
     *         TreeNode left = lowestCommonAncestor(root.left, p, q);
     *         TreeNode right = lowestCommonAncestor(root.right, p, q);
     *         if (left != null && right != null) {
     *             return root;
     *         } else if (left != null) {
     *             return left;
     *         } else if (right != null) {
     *             return right;
     *         }
     *         return null;
     *     }
     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        joint.put(root.val, null);
        preOrder(root);
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        while (p!=null && joint.containsKey(p.val)){
            pStack.push(p);
            p = joint.get(p.val);
        }
        while (q!=null && joint.containsKey(q.val)){
            qStack.push(q);
            q = joint.get(q.val);
        }
        TreeNode pre = null;
        while (!pStack.isEmpty() && !qStack.isEmpty()){
            p = pStack.pop();
            q = qStack.pop();
            if(p.val==q.val){
                pre = p;
            }else {
                break;
            }
        }
        return pre;
    }

    private void preOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            joint.put(root.left.val, root);
            preOrder(root.left);
        }
        if(root.right!=null){
            joint.put(root.right.val, root);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node3.left = node5;
        node3.right = node1;
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        node5.left = node2;
        node5.right = node6;
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node1.left = node0;
        node1.right = node8;
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node2.left = node7;
        node2.right = node4;
        TreeNode ret = new Solution236().lowestCommonAncestor(node3, node5, node4);
        System.out.println(ret.val);
    }
}
