package com.dxw.GraphWeight.MST;

import com.dxw.GraphWeight.Edge;
import com.dxw.GraphWeight.Impl.SparseWeightedGraph;
import com.dxw.GraphWeight.MST.MinHeap.MinHeap;
import com.dxw.GraphWeight.ReadGraph.ReadGraph;
import com.dxw.GraphWeight.WeightedGraph;

import java.io.File;
import java.util.Vector;

public class LazyPrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> g;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked; //节点是否被标记过
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;


    public LazyPrimMST(WeightedGraph<Weight> g) {
        this.g = g;
        marked = new boolean[g.V()];
        pq = new MinHeap<Edge<Weight>>(g.E());
        for (int i = 0; i < g.V(); i++) {
            marked[i] = false;
        }
        mst = new Vector<Edge<Weight>>();
        //Lazy Prim
        visit(0);
        while (!pq.isEmpty()){
            Edge<Weight> e = pq.extractMin();
            if(marked[e.v()]==marked[e.w()]){
                continue;
            }
            mst.add(e);
            if(!marked[e.v()]){
                visit(e.v());
            }else {
                visit(e.w());
            }
        }

        mstWeight = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    private void visit(int v){
        assert (!marked[v]);
        marked[v] = true;
        for(Edge<Weight> e:g.adj(v)){
            if(!marked[e.other(v)]){
                pq.insert(e);
            }
        }
    }

    public Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    public Number result(){
        return mstWeight;
    }

    public static void main(String[] args) {
        File directory = new File("");// 设定为当前文件夹
        String path = directory.getAbsolutePath();
        String file = "src\\main\\java\\com\\dxw\\GraphWeight\\testG1.txt";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename =  path + File.separator +file;
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
