package com.leetcode;

import com.dxw.stack.leetcode.Solution;

import static com.leetcode.Utils.printArray;

public class Solution48 {
    public void rotate(int[][] matrix) {
        /***
         旋转90度==先水平翻转，再主对角线翻转
         */
        int n = matrix.length;
        //水平翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        //主对角线翻转
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Solution48().rotate(input);
        printArray(input);
    }
}
