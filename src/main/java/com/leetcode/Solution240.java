package com.leetcode;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角遍历，matrix[i][j]比target大，坐标下移；比target小，坐标左移
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0; int j = n-1;
        while (i<m&&j>=0){
            if(target==matrix[i][j]){
                return true;
            }else if(target>matrix[i][j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{-5}};
        int target = -10;
        boolean ans = new Solution240().searchMatrix(input,target);
        System.out.println(ans);
    }
}
