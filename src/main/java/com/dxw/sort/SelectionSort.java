package com.dxw.sort;

public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

//    public static void sort(int arr[]){
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            //寻找[i,n)区间的最小值
//            int minIndex = i;
//            for (int j = i+1; j < n; j++) {
//                if(arr[j]<arr[minIndex]){
//                    minIndex = j;
//                }
//            }
//            Utils.swap(arr,i,minIndex);
//        }
//    }

    public static void sort(Comparable arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //寻找[i,n)区间的最小值
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j].compareTo(arr[minIndex])<0){
                    minIndex = j;
                }
            }
            Utils.swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{2,1,4,7,5,3,6};
        SelectionSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }
        System.out.println();

        Character[] characters = new Character[]{'a','c','b','e','d'};
        SelectionSort.sort(characters);
        Utils.printArray(characters);
        System.out.println();

        Integer[] randomNums = Utils.generateRandomArray(10,0,10);
        SelectionSort.sort(randomNums);
        Utils.printArray(randomNums);

        Integer[] randomNums2 = Utils.generateRandomArray(10000,0,100000);
        Utils.testSort("com.dxw.sort.SelectionSort",randomNums2);
        Utils.printArray(randomNums2);
    }
}
