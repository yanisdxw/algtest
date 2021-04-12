package com.leetcode.p_2pointer;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //标记位
        int prev = 0;
        int next = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int target = n/2;
        int i = 0,j = 0;
        int p = 0;
        while(p<=target){
            prev = next;
            if(i<n1 && (nums1[i]<nums2[j]||j>=n2)){
                next = nums1[i++];
            }else{
                next = nums2[j++];
            }
            p++;
        }

        if(n%2==1){
            //奇数
            return next;
        }else{
            //偶数
            return (prev+next)/2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double res = new Solution4().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
