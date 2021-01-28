package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import static com.leetcode.Utils.printArray;

public class Solution934 {

    int[] direction = new int[]{-1,0,1,0,-1};

    public int shortestBridge(int[][] A) {
        Queue<Pos> points = new LinkedList<>();
        boolean filled = false;
        int m = A.length; int n = A[0].length;
        //dfs做初始化，找到第一个岛并涂色1-->2
        for (int i = 0; i < m; i++) {
            if(filled) break;
            for (int j = 0; j < n; j++) {
                if(A[i][j] == 1){
                    dfs(A,points,m,n,i,j);
                    filled = true;
                    break;
                }
            }
        }
        printArray(A);
        int path = 0;
        int x,y;
        //bfs找最短路径
        while (!points.isEmpty()){
            path++;
            int n_points = points.size();
            while (n_points-->0){
                Pos p = points.poll();
                for (int k = 0; k < direction.length-1; k++) {
                    x = p.x + direction[k];
                    y = p.y + direction[k+1];
                    if(x>=0 && y>=0 && x<m && y<n){
                        if(A[x][y]==2){
                            continue;
                        }
                        if(A[x][y]==1){
                            return path;
                        }
                        points.add(new Pos(x,y));
                        A[x][y]=2;

                    }
                }
            }

        }
        return 0;
    }

    private void dfs(int[][] A, Queue<Pos> points, int m, int n, int i ,int j){
        //越界
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }
        //已遍历过
        if(A[i][j]==2){
            return;
        }
        //遇到水，加到队列中
        if(A[i][j]==0){
            points.add(new Pos(i,j));
            return;
        }
        A[i][j]=2;
        dfs(A, points, m, n, i+1, j);
        dfs(A, points, m, n, i-1, j);
        dfs(A, points, m, n, i, j+1);
        dfs(A, points, m, n, i, j-1);
    }

    class Pos {
        public int x;
        public int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,1,0},{0,0,0},{0,0,1}};
        int path = new Solution934().shortestBridge(A);
        System.out.println(path);
    }
}
