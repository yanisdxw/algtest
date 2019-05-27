package com.dxw.GraphWeight.ReadGraph;


import com.dxw.GraphWeight.Impl.DenseWeightedGraph;
import com.dxw.GraphWeight.Impl.SparseWeightedGraph;

import java.io.File;

public class ReadTest {
    public static void main(String[] args) {

        File directory = new File("");// 设定为当前文件夹

        try {

            System.out.println(directory.getCanonicalPath());// 获取标准的路径

            System.out.println(directory.getAbsolutePath());// 获取绝对路径

        } catch (Exception e) {

        }

        String path = directory.getAbsolutePath();
        String file = "src\\main\\java\\com\\dxw\\GraphWeight\\testG1.txt";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename =  path + File.separator +file;

        SparseWeightedGraph g1 = new SparseWeightedGraph(8, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse WeightedGraph:");
        g1.show();

        System.out.println();

        DenseWeightedGraph g2 = new DenseWeightedGraph(8, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename);
        System.out.println("test G1 in Dense WeightedGraph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
//        filename = "testG2.txt";
//        SparseWeightedGraph g3 = new SparseWeightedGraph(6, false);
//        ReadGraph readGraph3 = new ReadGraph(g3, filename);
//        System.out.println("test G2 in Sparse WeightedGraph:");
//        g3.show();
//
//        System.out.println();
//
//        DenseWeightedGraph g4 = new DenseWeightedGraph(6, false);
//        ReadGraph readGraph4 = new ReadGraph(g4, filename);
//        System.out.println("test G2 in Dense WeightedGraph:");
//        g4.show();
    }
}
