package com.dxw.Graph.ShortestPath;

import com.dxw.Graph.GraphImpl.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private Graph g;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph g, int s){
        //算法初始化
        assert (s>=0 && s<g.V());
        visited = new boolean[g.V()];
        from = new int[g.V()];
        ord = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
        Queue<Integer> q = new LinkedList<>();
        //无向图最短路径
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()){
            int v = q.remove();
            for(int i:g.adj(v)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] +1;
                }
            }
        }

    }

    public boolean hasPath(int w){
        assert (w>=0 && w<g.V());
        return visited[w];
    }

    public Vector<Integer> path(int w){
        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p!=-1){
            stack.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<Integer>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public void showPath(int w){
        Vector<Integer> vec;
        vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if(i==vec.size()-1){
                System.out.println();
            }else {
                System.out.print("->");
            }
        }
    }
}
