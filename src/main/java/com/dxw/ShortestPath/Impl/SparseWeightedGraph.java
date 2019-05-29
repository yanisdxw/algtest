package com.dxw.ShortestPath.Impl;

import com.dxw.GraphWeight.Edge;
import com.dxw.ShortestPath.WeightedGraph;

import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n,m;
    private boolean directed;
    private Vector<Edge<Weight>>[] g; // 图的具体数据

    public SparseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Edge<Weight>>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++)
            g[i] = new Vector<Edge<Weight>>();
    }

    public int V(){
        return n;
    }

    public int E(){
        return m;
    }

    //允许有平行边，因为判断平行边为o(n)复杂度
    public void addEdge(int v, int w, Weight weight){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);
        g[v].add(new Edge<>(v,w,weight));
        //判断自环边
        if(v!=w && !directed){
            g[w].add(new Edge<>(v,w,weight));
        }
        m++;
    }

    public void addEdge(Edge e){
        assert (e.v()>=0 && e.v()<n);
        assert (e.w()>=0 && e.w()<n);
        g[e.v()].add(new Edge(e));
        //判断自环边
        if(e.v()!=e.w() && !directed){
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m++;
    }

    public boolean hasEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && v<n);
        for (int i = 0; i < g[v].size(); i++) {
            if(g[v].elementAt(i)!=null){
                return true;
            }
        }
        return false;
    }


    // 显示图的信息
    public void show(){
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].elementAt(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    // // 返回图中一个顶点的所有邻边
    // // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Edge<Weight>> adj(int v){
        assert (v>=0 && v<n);
        return g[v];
    }
}
