package com.dxw.SegmentTree;

import java.util.Arrays;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4*arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex,int l, int r){
        if(l==r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        //防止整数溢出
        int mid = l + (r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        //取决于业务需求
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>=data.length){
            throw  new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    //返回区间L,R的值
    public E query(int queryL,int queryR){
        if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length){
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }
    //在以treeID为根的线段树中的[l...r]的范围里，搜索区间[queryL,queryR]
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int mid = l + (r - l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //左边界和左孩子无关系，去右子树查找
        if(queryL >= mid + 1){
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }else if(queryR<=mid){
        //右边界和右孩子无关系，去左子树查找
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }
        //查找区间一部分在左孩子，一部分在右孩子,去两边找
        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftResult,rightResult);
    }

    //将index位置的值更新
    public void set(int index,E e){
        if(index<0||index>=data.length){
            throw  new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    //在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        //只需要在右子树找
        if(index>=mid+1){
            set(rightTreeIndex,mid+1,r,index,e);
        }else {
            set(leftTreeIndex,l,mid,index,e);
        }
        //更新了叶子节点，然后更新祖辈节点
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if(tree[i]!=null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }

            if(i!=tree.length-1){
                res.append(',');
            };
        }
        res.append(']');
        return res.toString();
    }
}
