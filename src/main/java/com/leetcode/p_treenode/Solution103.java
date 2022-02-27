package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList();
        if(root!=null){
            queue.add(root);
        }
        int level = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> ll = new ArrayList();
            while(len-->0){
                TreeNode t = queue.poll();
                ll.add(t.val);
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            //偶数层逆序
            if((level&1)==0) Collections.reverse(ll);
            res.add(ll);
            level++;
        }
        return res;
    }
}
