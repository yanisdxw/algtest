package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

public class leetcode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null)
            return p==q;

        if(q.val==p.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        return false;
    }
}
