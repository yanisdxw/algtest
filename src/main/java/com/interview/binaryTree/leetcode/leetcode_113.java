package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_113 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return res;
        }

        LinkedList<Integer> tres = new LinkedList<>();
        dfs(root,tres,0,sum);
        return res;
    }

    private void dfs(TreeNode node, LinkedList tres, int tsum, int sum){

        tres.add(node.val);
        tsum += node.val;

        if(node.left==null && node.right==null){
            if(tsum==sum){
                res.add(new LinkedList<>(tres));
            }
        }else {
            if(node.left!=null){
                dfs(node.left, tres, tsum, sum);
            }

            if(node.right!=null){
                dfs(node.right, tres, tsum, sum);
            }
        }

        tres.removeLast();
        return;
    }

    public static void main(String[] args) {

    }
}
