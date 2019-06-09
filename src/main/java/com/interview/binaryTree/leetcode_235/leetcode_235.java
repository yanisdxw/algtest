package com.interview.binaryTree.leetcode_235;

import com.interview.stack.TreeNode;

public class leetcode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        assert (p!=null && q!=null);

        if(root==null){
            return null;
        }

        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}
