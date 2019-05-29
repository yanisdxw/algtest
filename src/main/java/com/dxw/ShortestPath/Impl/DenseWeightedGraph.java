package com.dxw.ShortestPath.Impl;

import com.dxw.GraphWeight.Edge;
import com.dxw.ShortestPath.WeightedGraph;

import java.util.Vector;

//稠密图  - 邻接矩阵
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n,m;
    private boolean directed;
    private Edge[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        this.n = n; //顶点
        this.m = 0; //边
        this.directed = directed;
        g = new Edge[n][n];
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < n ; j ++)
                g[i][j] = null;
    }

    public int V(){
        return n;
    }

    public int E(){
        return m;
    }

    public void addEdge(int v, int w, Weight weight){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);

        if(hasEdge(v,w)){

            return;
        }

        g[v][w] = new Edge<Weight>(v,w,weight);
        if(!directed){
            g[w][v] = new Edge<Weight>(v,w,weight);
        }
        m++;
    }

    public void addEdge(Edge e){
        assert (e.v()>=0 && e.v()<n);
        assert (e.w()>=0 && e.v()<n);

        if(hasEdge(e.v(),e.w())){
            return;
        }

        g[e.v()][e.w()] = new Edge(e);
        if(!directed){
            g[e.w()][e.v()] = new Edge(e.w(),e.v(),e.wt());
        }
        m++;
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                if(g[i][j]!=null){
                    System.out.print(g[i][j].wt()+"\t");
                }else {
                    System.out.print("NULL\t");
                }
            //System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    public boolean hasEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && w<n);
        return g[v][w]!=null;
    }

    public Iterable<Edge<Weight>> adj(int v){
        assert (v>=0 && v<n);
        Vector<Edge<Weight>> vector = new Vector(n);
        for (int i = 0; i < n; i++) {
            if(g[v][i]!=null){
                vector.add(g[v][i]);
            }
        }
        return vector;
    }

}
