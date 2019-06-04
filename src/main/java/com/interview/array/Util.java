package com.interview.array;

public class Util {
    private Util(){}

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {

        assert n > 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    public static void swap(Comparable arr[], int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static Integer[] toIntegerArray(int[] arr){
        int n=arr.length;
        Integer[] iarr=new Integer[n];
        for(int i=0;i<n;i++){
            iarr[i]=new Integer(arr[i]);
        }
        return iarr;
    }


    public static void printArray(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
