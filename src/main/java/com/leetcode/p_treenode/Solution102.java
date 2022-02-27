package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            while (len-->0){
                TreeNode t = queue.poll();
                level.add(t.val);
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            res.add(level);
        }
        return res;
    }
}
