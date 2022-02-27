package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        if(p.val!=q.val){
            return false;
        }else{
            return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
        }
    }
}
