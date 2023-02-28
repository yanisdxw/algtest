package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution655 {

    //求二叉树的高度和宽度
    private int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = dfs(root.left); int[] right = dfs(root.right);
        return new int[]{Math.max(left[0],right[0])+1,Math.max(left[1],right[1])*2+1};
    }

    private List<List<String>> ans = new ArrayList();

    public List<List<String>> printTree(TreeNode root) {
        int[] hw = dfs(root);
        int h = hw[0]; int w = hw[1];
        for(int i=0;i<h;i++){
            List<String> tmp = new ArrayList();
            for(int j=0;j<w;j++){
                tmp.add("");
            }
            ans.add(tmp);
        }
        print(root,0,0,w-1);
        return ans;
    }

    private void print(TreeNode root, int h, int l, int r){
        if(root==null) return;
        int mid = (l+r)/2;
        ans.get(h).set(mid, String.valueOf(root.val));
        print(root.left,h+1,l,mid-1);
        print(root.right,h+1,mid+1,r);
    }
}
