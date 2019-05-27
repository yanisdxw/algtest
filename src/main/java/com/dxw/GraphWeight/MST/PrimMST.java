package com.dxw.GraphWeight.MST;

import com.dxw.GraphWeight.Edge;
import com.dxw.GraphWeight.Impl.SparseWeightedGraph;
import com.dxw.GraphWeight.MST.IndexMinHeap.IndexMinHeap;
import com.dxw.GraphWeight.ReadGraph.ReadGraph;
import com.dxw.GraphWeight.WeightedGraph;

import java.io.File;
import java.util.Vector;

public class PrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> g;
    private IndexMinHeap<Weight> ipq; // 最小索引堆, 算法辅助数据结构
    private Edge<Weight>[] edgeTo;        // 访问的点所对应的边, 算法辅助数据结构
    private boolean[] marked; //节点是否被标记过
    private Vector<Edge<Weight>> mst; // 最小生成树所包含的所有边
    private Number mstWeight;  // 最小生成树的权值

    public PrimMST(WeightedGraph g){
        this.g = g;
        assert( g.E() >= 1 );
        ipq = new IndexMinHeap<Weight>(g.V());

        // 算法初始化
        marked = new boolean[g.V()];
        edgeTo = new Edge[g.V()];
        for( int i = 0 ; i < g.V() ; i ++ ){
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new Vector<Edge<Weight>>();
        //Prim
        visit(0);
        while (!ipq.isEmpty()){
            int v = ipq.extractMinIndex();
            assert (edgeTo[v]!=null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
    }

    private void visit(int v){
        assert (!marked[v]);
        marked[v] = true;
        for(Edge<Weight> e:g.adj(v)){
            int w = e.other(v);
            if(!marked[w]){
                if(edgeTo[w]==null){
                    ipq.insert(w,e.wt());
                    edgeTo[w] = e;
                }else if( e.wt().compareTo(edgeTo[w].wt()) < 0){
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    }

    // 测试 Prim
    public static void main(String[] args) {

        File directory = new File("");// 设定为当前文件夹
        String path = directory.getAbsolutePath();
        String file = "src\\main\\java\\com\\dxw\\GraphWeight\\testG1.txt";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename =  path + File.separator +file;

        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(g);
        Vector<Edge<Double>> mst = primMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();
    }
}
