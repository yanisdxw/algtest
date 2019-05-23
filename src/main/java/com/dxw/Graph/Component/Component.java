package com.dxw.Graph.Component;

import com.dxw.Graph.GraphImpl.Graph;

public class Component {

    private Graph g;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Component(Graph graph){
        g = graph;
        visited = new boolean[g.V()];
        ccount = 0;
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
        }

        for (int i = 0; i < g.V(); i++) {
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs(int v){
        visited[v] = true;
        id[v] = ccount;
        for( int i: g.adj(v) ){
            if( !visited[i] )
                dfs(i);
        }
    }

    public int count(){
        return ccount;
    }

    public boolean isConnected(int v, int w){
        assert (v>=0 && v<g.V());
        assert (w>=0 && v<g.V());
        return id[v]==id[w];
    }

}
