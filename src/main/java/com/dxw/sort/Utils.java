package com.dxw.sort;

import java.lang.reflect.Method;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.isSorted;

public class Utils {

    public static void swap(Object arr[], int a, int b){
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rangeL + random.nextInt(rangeR);
        }
        return arr;
    }

    public static void printArray(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void testSort(String sortClassName, Comparable[] arr){
        try{
            //通过sortClassName获得排序函数Class对象
            Class sortClass = Class.forName(sortClassName);
            //通过排序函数Class对象获取排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            //排序参数只有一个,是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            //调用函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName()+": "+(endTime - startTime)+"ms");
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
