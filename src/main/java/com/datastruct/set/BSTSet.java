package com.datastruct.set;

import com.datastruct.BST.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<E>();
    }



    public void add(E e) {
        bst.add(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public int getSize() {
        return bst.getSize();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
