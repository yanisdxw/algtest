package com.dxw.Trie;

import java.util.TreeMap;

//不是泛型了(默认英文)
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得单词的数量
    public int getSize(){
        return size;
    }

    //向Trie添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }

    }

    //查询单词word是否在trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    //查找是否在Trie中是否有单词以prefix为前缀
    //前缀长度作为时间复杂度
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
