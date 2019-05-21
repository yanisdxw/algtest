package com.dxw.sort;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){ }

    public static void sort(Comparable[] arr){
        sort(arr,0,arr.length-1);
    }

    //使用递归归并排序，对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){
        if(l>=r){
            //只用一个元素,不需要排序
            return;
        }
        //注意这种写法不规范
        int mid = (l+r)/2;

        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
//        //左边完全小于右边时不用归并(近乎有序时的优化)
//        if(arr[mid].compareTo(arr[mid+1])<0){
//            merge(arr,l,mid,r);
//        }
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

    public static void main(String[] args) {
        Integer[] nums = Utils.generateRandomArray(50000,0,10000);
        Integer[] nums2 = nums.clone();

        Utils.testSort("com.dxw.sort.InsertionSort",nums);
        Utils.testSort("com.dxw.sort.MergeSort",nums2);
    }
}
