package com.dxw.sort;

public class InsertionSort {
    private InsertionSort(){
    }

//    public static void sort(Comparable arr[]){
//        //从第2个开始因为第一个已经有序了
//        for (int i = 1; i < arr.length; i++) {
//            //寻找元素arr[i]合适的插入位置
//            for (int j = i; j > 0; j--) {
//                if(arr[j].compareTo(arr[j-1])<0){
//                    Utils.swap(arr,j,j-1);
//                }else {
//                    //已经在合适的位置了,不需要再和前面的比较了
//                    break;
//                }
//            }
//        }
//    }

    //未改进，多次交换
//    public static void sort(Comparable arr[]){
//        //从第2个开始因为第一个已经有序了
//        for (int i = 1; i < arr.length; i++) {
//            //寻找元素arr[i]合适的插入位置
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1])<0; j--) {
//                    Utils.swap(arr,j,j-1);
//            }
//        }
//    }

    //已改进，一次交换
    public static void sort(Comparable arr[]){
        //从第2个开始因为第一个已经有序了
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            Comparable e = arr[i];
            int j=i;
            for ( ; j > 0 && arr[j-1].compareTo(e)>0; j--) {
                arr[j] = arr[j-1];
            }
            //找到合适的位置（e比前面的元素大，比后面的元素小）再把元素插进去
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = Utils.generateRandomArray(10000,0,100);
        Integer[] nums2 = nums.clone();

        Utils.testSort("com.dxw.sort.SelectionSort",nums2);
        Utils.testSort("com.dxw.sort.InsertionSort",nums);
        //Utils.testSort("com.dxw.sort.SelectionSort",nums2);


    }
}
