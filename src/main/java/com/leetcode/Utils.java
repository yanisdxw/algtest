package com.leetcode;

public class Utils {
    public static void printArray(int[] nums){
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i!=nums.length-1){
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    public static void printArray(int[][] nums){
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            printArray(nums[i]);
            if(i!=nums.length-1){
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    public static String toArrayStr(int[] nums){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if(i!=nums.length-1){
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
