package com.dxw.ShortestPath;

import com.dxw.Graph.GraphImpl.Graph;
import com.dxw.GraphWeight.Edge;
import com.dxw.ShortestPath.Impl.SparseWeightedGraph;
import com.dxw.ShortestPath.ReadGraph.ReadGraph;

import java.io.File;
import java.util.Stack;
import java.util.Vector;

public class BellmanFord<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> g;
    private int s;
    private Number[] distTo;
    private boolean[] marked;
    private Edge<Weight>[] from;
    private boolean hasNegativeCycle;

    private boolean detectNegativeCycle(){
        //Relaxation
        for (int i = 0; i < g.V(); i++) {
            for(Edge<Weight> e:g.adj(i)){
                if(from[e.w()]==null||distTo[e.v()].doubleValue()+e.wt().doubleValue()<distTo[e.w()].doubleValue()){
                    return true;
                }
            }
        }
        return false;
    }

    public BellmanFord(WeightedGraph<Weight> g, int s){
        this.s = s;
        this.g = g;
        distTo = new Number[g.V()];
        from = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            from[i] = null;
        }
        //BellmanFord
        distTo[s] = 0.0;
        //对所有的点做v-1次松弛操作
        for (int pass = 1; pass < g.V(); pass++) {
            //Relaxation
            for (int i = 0; i < g.V(); i++) {
                for(Edge<Weight> e:g.adj(i)){
                    if(from[e.w()]==null||distTo[e.v()].doubleValue()+e.wt().doubleValue()<distTo[e.w()].doubleValue()){
                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    public boolean negativeCycle(){
        return hasNegativeCycle;
    }

    public Weight shortestPathTo(int w){
        assert (w>=0 && w<g.V());
        assert (!hasNegativeCycle);
        return (Weight) distTo[w];
    }

    public boolean hasPathTo(int w){
        assert (w>=0 && w<g.V());
        return from[w]!=null;
    }

    public Vector<Edge<Weight>> shortestPath(int w){
        assert (w>=0 && w<g.V());
        assert (!hasNegativeCycle);
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> e = from[w];
        while (e.v()!=this.s){
            stack.push(e);
            e = from[e.v()];
        }
        stack.push(e);
        Vector<Edge<Weight>> res = new Vector<>();

        while (!stack.isEmpty()){
            e = stack.pop();
            res.add(e);
        }
        return res;
    }

    public void showPath(int w){
        assert w >= 0 && w < g.V();
        assert (!hasNegativeCycle);
        assert hasPathTo(w);

        Vector<Edge<Weight>> path =  shortestPath(w);
        for( int i = 0 ; i < path.size() ; i ++ ){
            System.out.print( path.elementAt(i).v() + " -> ");
            if( i == path.size()-1 )
                System.out.println(path.elementAt(i).w());
        }
    }

    public static void main(String[] args) {

        File directory = new File("");// 设定为当前文件夹
        String path = directory.getAbsolutePath();
        String file = "src\\main\\java\\com\\dxw\\ShortestPath\\textG2.txt";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename =  path + File.separator +file;
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadGraph readGraph = new ReadGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g, s);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 0 ; i < V ; i ++ ){
                if(i == s)
                    continue;

                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

                System.out.println("----------");
            }
    }
}
