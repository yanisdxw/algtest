package com.dxw.sort;

import java.util.Arrays;

//自低向上的归并排序:不需要递归
public class MergeSortBU {

    public static void sort(Comparable[] arr){
        for (int sz = 1; sz <= arr.length ; sz+=sz) {
            for (int i = 0; i < arr.length; i+=sz+sz) {
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,arr.length-1));
            }
        }
    }

    //将arr[l...mid] 和 arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r){
        //辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        //i是左半边索引,j是右半边索引
        int i = l, j = mid +1;
        //减去l是为了减去偏移量
        for (int k = l; k <= r ; k++) {
            //先判断索引是否越界
            if(i>mid){ //如果左半边元素处理全部完毕
                arr[k] = aux[j-l];
                j++;
            }else if(j>r) { //如果右半边元素处理全部完毕
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l])<0){
                //然后比较左右两个索引对应的值大小
                arr[k] = aux[i-l];
                i++;
            }else {
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
