package com.interview.binaryTree;

import com.interview.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TravelSys {

    public List<Integer> preorderTraversal(TreeNode root) {
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
