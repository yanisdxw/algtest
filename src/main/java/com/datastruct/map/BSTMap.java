package com.datastruct.map;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    //向BST添加新元素(key,value)
    //从根节点开始，大于往右，小于往左
    @Override
    public void add(K key, V value){
        root = add(root,key,value);
    }

    //向以node为根的BTS插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){
        if(node == null){
            size ++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node.left;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
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

    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

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


    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null?null:node.value;
    }

    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node==null){
            throw new IllegalArgumentException(key+"doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("a");
        words.add("b");
        words.add("c");
        words.add("a");
        BSTMap<String,Integer> map = new BSTMap<>();
        for(String word:words){
            if(map.contains(word)){
                map.set(word,map.get(word)+1);
            }else {
                map.add(word,1);
            }
        }
        System.out.println(map.get("a"));
    }
}
