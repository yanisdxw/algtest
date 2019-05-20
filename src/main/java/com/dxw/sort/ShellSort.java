package com.dxw.sort;

public class ShellSort {
    // 我们的算法类不允许产生任何实例
    private ShellSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            //相当于将插入排序中的i换成了h
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    //对比插入排序
//    public static void sort(Comparable arr[]){
//        //从第2个开始因为第一个已经有序了
//        for (int i = 1; i < arr.length; i++) {
//            //寻找元素arr[i]合适的插入位置
//            Comparable e = arr[i];
//            int j=i;
//            for ( ; j > 0 && arr[j-1].compareTo(e)>0; j--) {
//                arr[j] = arr[j-1];
//            }
//            arr[j] = e;
//        }
//    }

    public static void main(String[] args) {
        Integer[] nums = Utils.generateRandomArray(10000,0,100);
        Integer[] nums2 = nums.clone();
        Integer[] nums3 = nums.clone();
        Integer[] nums4 = nums.clone();

        Utils.testSort("com.dxw.sort.BubbleSort",nums);
        Utils.testSort("com.dxw.sort.SelectionSort",nums2);
        Utils.testSort("com.dxw.sort.InsertionSort",nums3);
        Utils.testSort("com.dxw.sort.ShellSort",nums4);
    }
}
