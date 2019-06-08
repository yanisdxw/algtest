package com.interview.recursive.leetcode_257;

import com.interview.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        if(root.left==null && root.right==null){
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for(int i=0; i < leftS.size(); i++){
            res.add(root.val+"->"+leftS.get(i));
        }

        List<String> rightS = binaryTreePaths(root.right);
        for(int i=0; i < rightS.size(); i++){
            res.add(root.val+"->"+rightS.get(i));
        }

        return res;
    }
}
