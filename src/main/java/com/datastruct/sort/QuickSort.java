package com.datastruct.sort;


import com.leetcode.Utils;

import java.util.Arrays;

public class QuickSort {
    // 我们的算法类不允许产生任何实例
    private QuickSort(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){
        /**
         // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
         swap( arr, l , (int)(Math.random()*(r-l+1))+l );
         */

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        if( l >= r )
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {
        int[] a = new int[]{2,5,4,1,3,7,6,8};
        Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
        int p = partition(arr,0,6);
        System.out.println(p);
        Utils.printArray(arr);
        return;
    }
}
