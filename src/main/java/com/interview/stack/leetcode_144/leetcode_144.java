package com.interview.stack.leetcode_144;


import com.interview.stack.TreeNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_144 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null){
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode p = stack.pop();
//            res.add(p.val);
//            if(p.right!=null)
//                stack.push(p.right);
//            if(p.left!=null)
//                stack.push(p.left);
//        }
//        return res;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if(command.s == "print"){
                res.add(command.node.val);
            }else {
                if(command.node.right!=null){
                    stack.push(new Command("go",command.node.right));
                }
                if(command.node.left!=null){
                    stack.push(new Command("go",command.node.left));
                }
                stack.push(new Command("print",command.node));
            }
        }
        return res;
    }

    public class Command{
        String s;
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }
}
