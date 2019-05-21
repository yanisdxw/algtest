package com.dxw.sort;

import java.util.Random;

public class QuickSort2 {
    private QuickSort2(){}

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
        //arr[l+1..i) <= v; arr(j+1...r]> v
        int i = l+1, j = r;
        while (true){
            //i<=r 防止越界
            while (i<=r && arr[i].compareTo(v)<0) i++;
            while (j>=l+1 && arr[j].compareTo(v)>0) j--;
            if(i>j) break;
            Utils.swap(arr,i,j);
            i++;
            j--;
        }
        Utils.swap(arr,l,j);
        return j;
    }
}
