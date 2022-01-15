package com.algorithm.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 走迷宫 {
    private static int m;
    private static int n;
    private static int[][] D;
    private static int[][] path;
    private static Queue<Point> q = new LinkedList();
//    //保存最短路径
//    private static Point[][] prev;
    //向量法
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{1,0,-1,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        D = new int[n][m];
        path = new int[n][m];
//        prev = new Point[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                D[i][j] = sc.nextInt();
                path[i][j] = 0;
            }
        }
        Point o = new Point(0,0);
        q.offer(o);
        bfs();

//        //输出最短路径
//        int x = n-1; int y = m-1;
//        while (x!=0 && y!=0){
//            Point t = prev[x][y];
//            System.out.println(t.x+" "+t.y);
//            x = t.x; y = t.y;
//        }

        System.out.print(path[n-1][m-1]);
    }

    private static void bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                Point pp = new Point(p.x+dx[i],p.y+dy[i]);
                if(pp.x>=0 && pp.x<n && pp.y>=0 && pp.y<m && D[pp.x][pp.y]==0 && path[pp.x][pp.y]==0){
                    path[pp.x][pp.y] = path[p.x][p.y] + 1;
                    //prev[pp.x][pp.y] = p;
                    q.offer(pp);
                }
            }
        }
    }


    static class Point {
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
