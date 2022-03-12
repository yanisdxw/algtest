package com.leetcode.p_treenode;

import java.util.*;

public class Solution116 {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root!=null){
            q.add(root);
        }
        while(!q.isEmpty()){
            int len = q.size();
            Node pre = null;
            while(len-->0){
                Node t = q.poll();
                t.next = pre;
                pre = t;
                if(t.right!=null) q.add(t.right);
                if(t.left!=null) q.add(t.left);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
