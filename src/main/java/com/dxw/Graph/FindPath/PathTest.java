package com.dxw.Graph.FindPath;

import com.dxw.Graph.ReadGraph.ReadGraph;
import com.dxw.Graph.GraphImpl.Impl.SparseGraph;

public class PathTest {
    public static void main(String[] args) {
        // TestG1.txt
        String filename1 = "testG.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        g1.show();

        Path path = new Path(g1,0);
        System.out.print("DFS: ");
        path.showPath(6);
    }

}
