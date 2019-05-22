package com.dxw.UnionFind;

public class UnionFind5 {
    private int[] parent;
    private int count;
    private int[] rank; //rank[i]表示以i为根的集合的层数

    public UnionFind5(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p){
        assert ( p >= 0 && p < count);

//        while (p!=parent[p]){
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;

        //进一步优化
        if(p!=parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot]<rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = parent[qRoot];
            rank[qRoot] +=1;
        }
    }
}
