package com.dxw.Graph.GraphImpl.Impl;

import com.dxw.Graph.GraphImpl.Graph;

import java.util.Vector;

//稠密图  - 邻接矩阵
public class DenseGraph implements Graph {
    private int n,m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n; //顶点
        this.m = 0; //边
        this.directed = directed;
        g = new boolean[n][n];
    }

    public int V(){
        return n;
    }

    public int E(){
        return m;
    }

    public void addEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);

        if(hasEdge(v,w)){
            return;
        }

        g[v][w] = true;
        if(!directed){
            g[w][v] = true;
        }
        m++;
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                if(g[i][j]){
                    System.out.print(1+"\t");
                }else {
                    System.out.print(0+"\t");
                }
            //System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    public boolean hasEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && w<n);
        return g[v][w];
    }

    public Iterable<Integer> adj(int v){
        assert (v>=0 && v<n);
        Vector<Integer> vector = new Vector(n);
        for (int i = 0; i < n; i++) {
            if(g[v][i]==true){
                vector.add(i);
            }
        }
        return vector;
    }

}
