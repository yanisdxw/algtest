package com.interview.recursive.leetcode_112;

import com.interview.stack.TreeNode;

public class leetcode_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val==sum;
        }
        if(hasPathSum(root.left,sum-root.val)){
            return true;
        }
        if(hasPathSum(root.right,sum-root.val)){
            return true;
        }
        return false;
    }
}
