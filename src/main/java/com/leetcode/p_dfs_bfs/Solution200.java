package com.leetcode.p_dfs_bfs;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution200 {

    private int ans = 0;
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] visited){
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0){
            return;
        }
        if(grid[x][y]=='0'){
            return;
        }
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        //分别向4个方向遍历
        dfs(x+1,y,grid,visited);
        dfs(x,y+1,grid,visited);
        dfs(x-1,y,grid,visited);
        dfs(x,y-1,grid,visited);
    }
}

/**
 * 网格问题的通用 DFS 遍历方法:
 *
 * void dfs(int[][] grid, int r, int c) {
 *     // 判断 base case
 *     if (!inArea(grid, r, c)) {
 *         return;
 *     }
 *     // 如果这个格子不是岛屿，直接返回
 *     if (grid[r][c] != 1) {
 *         return;
 *     }
 *     grid[r][c] = 2; // 将格子标记为「已遍历过」
 *
 *     // 访问上、下、左、右四个相邻结点
 *     dfs(grid, r - 1, c);
 *     dfs(grid, r + 1, c);
 *     dfs(grid, r, c - 1);
 *     dfs(grid, r, c + 1);
 * }
 *
 * // 判断坐标 (r, c) 是否在网格中
 * boolean inArea(int[][] grid, int r, int c) {
 *     return 0 <= r && r < grid.length
 *         	&& 0 <= c && c < grid[0].length;
 * }
 *
 * 作者：nettee
 * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
