package com.interview.recursive.leetcode_437;

import com.interview.stack.TreeNode;

public class leetcode_437 {
    //在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }

        //包含该节点
        int res = findPath(root, sum);
        //不包含该节点
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }

    //在以node为根节点的二叉树中,寻找包含node的路径,和为sum
    //返回这样的路径个数
    private int findPath(TreeNode node, int num){
        if(node==null){
            return 0;
        }
        int res = 0;
        if(node.val==num){
            res += 1;
        }

        res += findPath(node.left,num-node.val);
        res += findPath(node.right, num-node.val);

        return res;
    }
}
