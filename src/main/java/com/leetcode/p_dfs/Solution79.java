package com.leetcode.p_dfs;

public class Solution79 {
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j,board,word,visited,0);
            }
        }
        return find;
    }

    private void dfs(int i, int j, char[][] board, String word, boolean[][] visited, int pos){
        //超过了边界
        if(i>=board.length || i<0 || j>=board[0].length || j<0){
            return;
        }
        //已访问或该位置的值不对或已经找到结果
        if(visited[i][j]||find||board[i][j]!=word.charAt(pos)){
            return;
        }
        if(pos==word.length()-1){
            find = true;
            return;
        }
        visited[i][j] = true;
        //在4个方向遍历
        dfs(i-1, j, board, word, visited, pos+1);
        dfs(i+1, j, board, word, visited, pos+1);
        dfs(i, j-1, board, word, visited, pos+1);
        dfs(i, j+1, board, word, visited, pos+1);
        visited[i][j] = false;
    }
}
