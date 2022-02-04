package com.leetcode;

import com.leetcode.po.ListNode;

public class Utils {

    public static void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

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

    public static void printArray(char[] nums){
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i!=nums.length-1){
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    public static String toBinaryString(int n, int bit){
        String s = Integer.toBinaryString(n);
        int i = s.length();
        while (i++<bit){
            s = "0"+s;
        }
        return s;
    }

    public static void printArray(boolean[] st){
        System.out.print("[");
        for (int i = 0; i < st.length; i++) {
            System.out.print(st[i]);
            if(i!=st.length-1){
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    public static void printArray(Integer[] nums){
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

    public static void printListNode(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val);
            if(cur.next!=null) System.out.print("-->");
            cur = cur.next;
        }
    }
}
