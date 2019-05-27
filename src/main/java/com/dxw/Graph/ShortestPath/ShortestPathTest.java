package com.dxw.Graph.ShortestPath;

import com.dxw.Graph.FindPath.Path;
import com.dxw.Graph.GraphImpl.Impl.SparseGraph;
import com.dxw.Graph.ReadGraph.ReadGraph;

public class ShortestPathTest {
    public static void main(String[] args) {
        // TestG1.txt
        String filename1 = "testG.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        g1.show();

        Path dfs = new Path(g1,0);
        System.out.print("DFS: ");
        dfs.showPath(6);

        ShortestPath bfs = new ShortestPath(g1,0);
        System.out.print("BFS: ");
        bfs.showPath(6);
    }
}
