package com.dxw.Graph.ReadGraph;

import com.dxw.Graph.GraphImpl.Impl.DenseGraph;
import com.dxw.Graph.GraphImpl.Impl.SparseGraph;

import java.io.File;

public class ReadTest {
    public static void main(String[] args) {

        File directory = new File("");// 设定为当前文件夹

        try {

            System.out.println(directory.getCanonicalPath());// 获取标准的路径

            System.out.println(directory.getAbsolutePath());// 获取绝对路径

        } catch (Exception e) {

        }

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();
    }
}
