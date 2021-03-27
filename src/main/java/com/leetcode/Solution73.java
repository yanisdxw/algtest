package com.leetcode;

/**
 * 矩阵置零
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //将第一列第一行作为存储是否置为0的标志位
        //如果这一列或者这一行有0，则第一列和第一行的那个位置就置为0
        boolean flag_col = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0) flag_col = true;
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >0; j--) {
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            if(flag_col) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution73().setZeroes(matrix);
    }
}
