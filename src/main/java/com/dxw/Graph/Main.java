package com.dxw.Graph;

import com.dxw.Graph.GraphImpl.Impl.DenseGraph;
import com.dxw.Graph.GraphImpl.Impl.SparseGraph;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int N = 20;
        int M = 100;

        SparseGraph g1 = new SparseGraph(N,false);
        DenseGraph g2 = new DenseGraph(N,false);

        for (int i = 0; i < M; i++) {
            int a = (int) ((Math.random()*100)%N);
            int b = (int) ((Math.random()*100)%N);
            g1.addEdge(a,b);
            g2.addEdge(a,b);
        }

        for (int v = 0; v < N; v++) {
            System.out.print(v+":");
            Iterable<Integer> adj = g1.adj(v);
            Iterator Itr = adj.iterator();
            while (Itr.hasNext()){
                System.out.print(Itr.next()+" ");
            }
            System.out.println();
        }

        System.out.println("=========================");

        for (int v = 0; v < N; v++) {
            System.out.print(v+":");
            Iterable<Integer> adj = g2.adj(v);
            Iterator Itr = adj.iterator();
            while (Itr.hasNext()){
                System.out.print(Itr.next()+" ");
            }
            System.out.println();
        }
    }
}
