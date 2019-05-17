package com.dxw.Trie.leetcode_667;

import java.util.TreeMap;

class MapSum {

    private class Node{
        public int value;
        public TreeMap<Character,Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c= prefix.charAt(i);
            if(cur.next.get(c)==null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        //找到以cur为根节点的所有子树节点的value值和
        return sum(cur);
    }

    private int sum(Node node){

        //递归到底的情况，叶子节点
//        if(node.next.size()==0){
//            return node.value;
//        }

        int res = node.value;
        for(char c: node.next.keySet()){
            res += sum(node.next.get(c));
        }
        return res;
    }
}