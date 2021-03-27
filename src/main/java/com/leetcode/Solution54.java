package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Solution54 {

    //用来表示4个方向，依次为右{1,0},下{0,-1},左{-1,0},上{0,1}
    static final int[] Direction = new int[]{1,0,-1,0,1};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int k = 0; //k为转向的次数，初始为0
        int i = 0;
        int j = 0;
        while (true){
            if(visited[i][j]) break;
            ans.add(matrix[i][j]);
            visited[i][j] = true;
            j += Direction[k%4];
            i -= Direction[k%4+1];
            if(i>=m||i<0||j>=n||j<0||visited[i][j]){
                j -= Direction[k%4];
                i += Direction[k%4+1];
                k++; //调转方向
                j += Direction[k%4];
                i -= Direction[k%4+1];
                //先判断一下是否依然越界
                if(i>=m||i<0||j>=n||j<0){
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = new int[][]{{1}};
        List<Integer> ans = new Solution54().spiralOrder(matrix);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
