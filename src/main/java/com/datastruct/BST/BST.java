package com.datastruct.BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    //二分搜索树：储存的元素要有可比较性

    //不包含重复元素

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    //记录存储了多少个元素
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }

    //向BST添加新元素
    //从根节点开始，大于往右，小于往左
    public void add(E e){
        root = add(root,e);
    }

    //向以node为根的BTS插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }
//    private void add(Node node, E e){
//        if(e.equals(node.e)){
//            return;
//            //由于不是基础类型不能直接用大于号或小于号比较
//        }else if(e.compareTo(node.e)<0 && node.left==null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        }else if(e.compareTo(node.e)>0 && node.right==null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }else {
//            add(node.right,e);
//        }
//    }
    //看二分搜索树是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //二叉树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历非递归
    public void preOrderNR(){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    //层序遍历
    public void levelOrder(){
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //寻找二分搜索树的最小值
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大值
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }

    //删除最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树种的最小节点、
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null){
            //保存当前节点的右节点
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            //保存当前节点的左节点
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除值为e的节点
    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node,E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node.left;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node.right;
        }else{
            //待删除的节点左子树为空
            if(node.left==null){
                //保存当前节点的右节点
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除的节点右子树为空
            if(node.right==null){
                //保存当前节点的左节点
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //待删除的节点右子树左子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            //后继节点的右边指向被删除节点删除后继节点(去掉最小节点)后的新树
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node==null){
            res.append(genretaDepthString(depth)+"null\n");
            return;
        }
        res.append(genretaDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String genretaDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for(int num:nums){
            bst.add(num);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!bst.isEmpty()){
            list.add(bst.removeMin());
        }
        System.out.println(list);
        //        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.levelOrder();
//        System.out.println("min is: "+bst.minimum());
//        System.out.println();
//
//        System.out.println(bst);
//
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
    }
}
