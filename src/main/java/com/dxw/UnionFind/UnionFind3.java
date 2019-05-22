package com.dxw.UnionFind;

public class UnionFind3 {
    private int[] parent;
    private int count;
    private int[] sz; //sz[i]表示以i为根的集合中元素的个数

    public UnionFind3(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p){
        assert ( p >= 0 && p < count);
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p)==find(q);
    }

    //改进，判断两个元素大小，让元素小的并到元素多的。让树深度更小
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot){
            return;
        }
        if(sz[pRoot]<sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }

    }
}
