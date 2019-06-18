package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r){
        if(l>r){
            return null;
        }

        int mid =(l + r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid-1);
        root.right = sortedArrayToBST(nums, mid+1,r);
        return root;
    }

    public static void main(String[] args) {

    }
}
