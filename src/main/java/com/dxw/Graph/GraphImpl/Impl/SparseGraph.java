package com.dxw.Graph.GraphImpl.Impl;

import com.dxw.Graph.GraphImpl.Graph;

import java.util.Vector;

public class SparseGraph implements Graph {
    private int n,m;
    private boolean directed;
    private Vector<Integer>[] g; // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Integer>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++)
            g[i] = new Vector<Integer>();
    }

    public int V(){
        return n;
    }

    public int E(){
        return m;
    }

    //允许有平行边，因为判断平行边为o(n)复杂度
    public void addEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);
        g[v].add(w);
        //判断自环边
        if(v!=w && !directed){
            g[w].add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);
        for (int i = 0; i < g[v].size(); i++) {
            if(g[v].elementAt(i)==w){
                return true;
            }
        }
        return false;
    }


    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

    // // 返回图中一个顶点的所有邻边
    // // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v){
        assert (v>=0 && v<n);
        return g[v];
    }
}
