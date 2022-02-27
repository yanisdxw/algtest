package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList();
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int l, int r){
        List<TreeNode> res = new ArrayList();
        if(l>r) {
            res.add(null);
            return res;
        }
        for(int i=l;i<=r;i++){
            List<TreeNode> lefts = dfs(l,i-1);
            List<TreeNode> rights = dfs(i+1,r);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}
