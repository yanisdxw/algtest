package com.interview.stack.leetcode_102;

import com.interview.stack.TreeNode;
import java.util.*;

public class leetcode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int level = p.getValue();
            if(res.size()==level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);

            if(node.left!=null){
                queue.offer(new Pair<>(node.left,level+1));
            }
            if(node.right!=null){
                queue.offer(new Pair<>(node.right,level+1));
            }
        }
        return res;
    }

    class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}
