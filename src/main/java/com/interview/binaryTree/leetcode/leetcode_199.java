package com.interview.binaryTree.leetcode;

import com.interview.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        process(root, result, 0);
        return result;
    }

    public void process(TreeNode cur, List<Integer> result, int curDepth){
        if(cur == null){
            return;
        }
        if(curDepth == result.size()){
            result.add(cur.val);                    //每一层加进去的条件
        }

        process(cur.right, result, curDepth + 1); //先看右边
        process(cur.left, result, curDepth + 1);

    }

    public static void main(String[] args) {

    }
}
