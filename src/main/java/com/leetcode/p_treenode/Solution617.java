package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }else if(root1==null && root2!=null){
            return root2;
        }else if(root1!=null && root2==null){
            return root1;
        }else {
            root1.val += root2.val;
            root1.left = merge(root1.left, root2.left);
            root1.right = merge(root1.right, root2.right);
        }
        return root1;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(1,3,2);
        List<Integer> nums2 = Arrays.asList(2,1,3);

        TreeNode root1 = TreeNode.create(nums1);
        TreeNode root2 = TreeNode.create(nums2);

        TreeNode root = new Solution617().mergeTrees(root1,root2);
        System.out.println(TreeNode.travel(root));
    }
}
