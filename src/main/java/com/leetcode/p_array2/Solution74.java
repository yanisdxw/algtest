package com.leetcode.p_array2;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断m x n，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //先确定行数，再确定列数
        int low = 0;
        int high = matrix.length-1;
        if(target<matrix[low][0]||target>matrix[high][matrix[0].length-1]){
            return false;
        }
        if(high==low){
            return binarySearch(matrix[0],target);
        }
        while (low<high){
            int m = (low+high)/2;
            if(target==matrix[m][0]){
                return true;
            }else if(target>matrix[m][0]){
                low = m+1;
            }else {
                high = m-1;
            }
        }

        if(matrix[low][0]>target){
            return binarySearch(matrix[low-1],target);
        }else {
            return binarySearch(matrix[low],target);
        }
    }

    private boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int m = (left+right)/2;
            if(target==arr[m]){
                return true;
            }else if(target<arr[m]){
                right = m-1;
            }else {
                left =  m+1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean ans = new Solution74().searchMatrix(matrix, 0);
        System.out.println(ans);
    }

}
