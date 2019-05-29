package com.dxw.ShortestPath;

import com.dxw.Graph.GraphImpl.Graph;
import com.dxw.GraphWeight.Edge;
import com.dxw.ShortestPath.Impl.SparseWeightedGraph;
import com.dxw.ShortestPath.IndexMinHeap.IndexMinHeap;
import com.dxw.ShortestPath.ReadGraph.ReadGraph;
import jdk.nashorn.internal.codegen.types.NumericType;

import java.io.File;
import java.util.Stack;
import java.util.Vector;

public class Dijkstra<Weight extends Number & Comparable> {
    private WeightedGraph g;
    private int s;
    private Number[] distTo;
    private boolean[] marked;
    private Edge<Weight>[] from;

    //初始化
    public Dijkstra(WeightedGraph<Weight> g, int s){

        assert s >= 0 && s < g.V();

        this.s = s;
        distTo = new Number[g.V()];
        marked = new boolean[g.V()];
        from = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }
        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(g.V());
        //Dijkstra
        distTo[s] = 0.0;
        marked[s] = true;
        ipq.insert(s, (Weight) distTo[s]);
        while (!ipq.isEmpty()){
            int v = ipq.extractMinIndex();
            //distTo[v] 就是s到v的最短距离
            marked[v] = true;

            //v松弛操作：存不存在经过v达到另外一个点比不仅过v还要短
            //访问v所有的邻边
            for(Edge<Weight> e:g.adj(v)){
                //w为邻边上的另一个端点
                int w = e.other(v);
                //如果从s到w的最短路径还没有被找到
                if(!marked[w]){

                    //先经过v再到w的值 与 直接到w的值 比较
                    if(from[w]==null||distTo[v].doubleValue()+e.wt().doubleValue()<distTo[w].doubleValue()){
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if(ipq.contain(w)){
                            ipq.change(w,(Weight) distTo[w]);
                        }else {
                            ipq.insert(w,(Weight) distTo[w]);
                        }
                    }
                }
            }
        }
    }

    public Number shortestPathTo(int w){
        return distTo[w];
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }

    public Vector<Edge<Weight>> shortestPath(int w){
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
        String file = "src\\main\\java\\com\\dxw\\ShortestPath\\textG1.txt";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename =  path + File.separator +file;
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(g,0);
        for( int i = 1 ; i < V ; i ++ ){
            if(dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }
    }
}
