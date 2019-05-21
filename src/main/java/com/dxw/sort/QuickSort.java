package com.dxw.sort;

import java.util.Random;

public class QuickSort {
    private QuickSort(){}

    public static void sort(Comparable[] arr){

        sort(arr,0,arr.length-1);
    }

    private static void sort(Comparable[] arr, int l, int r){
        if(l>=r){
            return;
        }
        int p = partition(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    //返回p,使得arr[l...p-1]<arr[p];arr[p+1...r]>arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        //优化: 随机选择一个元素为标定元素
        Random random = new Random();
        int q = l+random.nextInt(r-l);
        Utils.swap(arr,q,l);

        Comparable v = arr[l];
        //arr[l+1..j] < v; arr[j+1...i)> v
        int j = l;
        for (int i = l+1; i <= r ; i++) {
            if(arr[i].compareTo(v)<0){
                Utils.swap(arr,j+1,i);
                j++;
            }
        }
        Utils.swap(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] nums = Utils.generateRandomArray(1000000,0,1000);
        Integer[] nums2 = nums.clone();
        Integer[] nums3 = nums.clone();

        Utils.testSort("com.dxw.sort.MergeSort",nums);
        Utils.testSort("com.dxw.sort.QuickSort",nums2);
        Utils.testSort("com.dxw.sort.QuickSort2",nums3);
    }
}
