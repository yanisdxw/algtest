package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            while (len-->0) {
                TreeNode t = queue.poll();
                level.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}
