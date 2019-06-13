package com.interview.binaryTree.leetcode;

import com.interview.linkedList.ListNode;
import com.interview.stack.TreeNode;

import java.util.*;

public class leetcode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode node = queue.poll().key;
            int level = queue.poll().value;

            //每一层加进去的条件
            if(level == res.size())
                res.add(new ArrayList<>());

            res.get(level).add(node.val);

            list.add(node.val);
            if(node.left!=null){
                queue.offer(new Pair(node.left,level+1));
            }
            if(node.right!=null){
                queue.offer(new Pair(node.right,level+1));
            }
        }
        return res;
    }

    class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K node, V level) {
            this.key = node;
            this.value = level;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
