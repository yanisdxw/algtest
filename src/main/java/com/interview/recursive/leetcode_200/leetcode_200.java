package com.interview.recursive.leetcode_200;

public class leetcode_200 {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private int m,n;
    private boolean[][] visited;

    private boolean inArea(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }

    //保证（x,y）合法且grid[x][y]是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if(inArea(newx,newy) && !visited[newx][newy] && grid[newx][newy]=='1'){
                dfs(grid,newx,newy);
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m==0){
            return 0;
        }
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1' && !visited[i][j]){
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
}
