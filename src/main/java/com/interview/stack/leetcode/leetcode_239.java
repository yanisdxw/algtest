package com.interview.stack.leetcode;


import java.util.*;

public class leetcode_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length==0) return new int[0];
        if(nums.length==1) return nums;

        int[] res = new int[nums.length-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            //移动左边界
            while (!queue.isEmpty() && queue.peekFirst()<i-k+1){
                queue.pollFirst();
            }

            //更新右边界
            while (!queue.isEmpty() && nums[i]> nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);

            if(i>=k-1){
                res[left++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


    private static void printDeque(Deque deque){
        System.out.print("First:[");
        int len = deque.size();
        for (int i = 0; i < len; i++) {
            System.out.print(deque.pollFirst());
            if(i!=len-1) System.out.print(",");
        }
        System.out.println("]:Last");
    }

    private static Deque makeDeque(int[] nums){
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            deque.offerFirst(nums[i]);
        }
        return deque;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        Deque q = makeDeque(nums);
        System.out.println(q.size());
        printDeque(q);
        q.offerFirst(1);
        System.out.println(q.size());
        printDeque(q);
    }
}
