package com.leetcode.po;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {
        this.val = -1;
    }
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //层序遍历重建二叉树
    public static TreeNode create(List<Integer> nums){
        if(nums.size()==0){
            return new TreeNode();
        }
        int index = 0;
        TreeNode root = new TreeNode(nums.get(index++));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(index<nums.size()){
                Integer val = nums.get(index++);
                if(val!=null){
                    node.left = new TreeNode(val);
                    queue.offer(node.left);
                }else {
                    node.left = null;
                }
            }
            if(index<nums.size()){
                Integer val = nums.get(index++);
                if(val!=null){
                    node.right = new TreeNode(val);
                    queue.offer(node.right);
                }else {
                    node.right = null;
                }
            }
        }
        return root;
    }
    //层序遍历二叉树
    public static List<Integer> travel(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return ans;
    }
}
