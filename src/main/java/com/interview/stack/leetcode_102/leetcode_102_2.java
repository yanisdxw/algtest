package com.interview.stack.leetcode_102;

import com.interview.stack.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int level = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                currentLevel.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(currentLevel);
        }
        return res;
    }
}
