package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    private List<String> ans = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return ans;
        dfs(root, String.valueOf(root.val));
        return ans;
    }

    private void dfs(TreeNode root, String path){
        if(root.left==null && root.right==null) {
            ans.add(path);
            return;
        }
        if(root.left!=null) dfs(root.left, path+"->"+root.left.val);
        if(root.right!=null) dfs(root.right, path+"->"+root.right.val);
    }
}
