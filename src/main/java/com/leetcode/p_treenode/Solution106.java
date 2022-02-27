package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {

    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int il, int ir, int pl, int pr){
        if(pl>pr) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int k = map.get(root.val);
        int l_il = il;
        int l_ir = k-1;
        int l_pl = pl;
        int l_pr = pr-1-(ir-k-1)-1;
        int r_il = k+1;
        int r_ir = ir;
        int r_pl = pr-1-(ir-k-1);
        int r_pr = pr-1;
        root.left = build(inorder,postorder,l_il,l_ir,l_pl,l_pr);
        root.right = build(inorder,postorder,r_il,r_ir,r_pl,r_pr);
//        root.left = build(inorder,postorder,il,k-1,pl,pr-1-(k-1-il)-1);
//        root.right = build(inorder,postorder,k+1,ir,pr-1-(k-1-il),pr-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode res = new Solution106().buildTree(inorder,postorder);
    }
}
