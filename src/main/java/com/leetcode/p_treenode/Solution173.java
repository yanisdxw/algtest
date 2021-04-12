package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 *
 */
public class Solution173 {

    //使用一个数据存储二叉搜索树的先序遍历结果
    //不过这种需要用o(n)的空间
//    class BSTIterator {
//        List<Integer> nodesArray = new ArrayList<>();
//        Iterator<Integer> iterator;
//        public BSTIterator(TreeNode root) {
//            //先中序遍历二叉搜索树
//            if(root==null) return;
//            inOrder(root);
//            iterator = nodesArray.listIterator();
//        }
//        public void inOrder(TreeNode node){
//            if(node==null) return;
//            inOrder(node.left);
//            nodesArray.add(node.val);
//            inOrder(node.right);
//        }
//        public int next() {
//            return iterator.next();
//        }
//        public boolean hasNext() {
//            return iterator.hasNext();
//        }
//    }

    //优化：使用一个栈存储当前node，遍历完就出栈
    //空间复杂度n(h)
    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        //先存储一部分节点到栈中
        private void treeNodePush(TreeNode node){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
        }

        public BSTIterator(TreeNode root) {
            //先中序遍历二叉搜索树
            if(root==null) return;
            treeNodePush(root);
        }

        public int next() {
            TreeNode top = stack.pop();
            treeNodePush(top.right);
            return top.val;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
