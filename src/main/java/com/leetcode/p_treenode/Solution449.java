package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb){
        if(root==null) return;
        sb.append(root.val);
        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        List<Integer> tmp = transfer(data);
        return rebuildTree(tmp,0,tmp.size()-1);
    }

    private List<Integer> transfer(String data){
        List<Integer> tmp = new ArrayList<>();
        for(String s:data.split(" ")){
            tmp.add(Integer.parseInt(s));
        }
        return tmp;
    }

    private TreeNode rebuildTree(List<Integer> data, int l, int r){
        if(l>r) return null;
        Integer value = data.get(l);
        TreeNode root = new TreeNode(value);
        int p = l+1;
        while (p<=r && data.get(p)<value) p++;
        root.left = rebuildTree(data,l+1,p-1);
        root.right = rebuildTree(data,p,r);
        return root;
    }
}
