package com.dxw.Graph.FindPath;

import com.dxw.Graph.GraphImpl.Graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private Graph g;
    private int s;
    private boolean[] visited;
    private int[] from; //访问的节点从哪里来的

    public Path(Graph graph, int s){
        g = graph;
        //算法初始化
        assert (s>=0 && s<g.V());
        visited = new boolean[g.V()];
        from = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        //寻路算法
        dfs(s);
    }

    private void dfs(int v){
        visited[v] = true;

        for( int i: g.adj(v) ){
            if( !visited[i] ){
                from[i] = v;
                dfs(i);
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
