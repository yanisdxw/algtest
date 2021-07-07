package com.leetcode.p_array;

import java.util.Arrays;

/**
 * 数组类Arrays工具
 */
public class ArraysExample {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3};
        int[] a2 = new int[]{1,2,3};
        //判断数组元素是否完全相等
        Arrays.equals(a1,a2);
        //复制数组前n位，若不足用0填充
        int[] b = Arrays.copyOf(a1,6);
        //复制数组第3到第4位
        int[] c = Arrays.copyOfRange(a1,2,3);
        //填充数组所有元素为1
        Arrays.fill(b,1);
        //填充数组第3到第4个元素为2
        Arrays.fill(b, 2,3,2);
        //排序数组
        Arrays.sort(b);
    }

}
