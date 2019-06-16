package com.interview.array.leetcode_88;

import com.interview.array.Util;

public class leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //技巧: 使用nums1的后半段存储nums1的元素，从而不用申请新空间
        for (int i = n+m-1; i >=n ; i--) {
            nums1[i] = nums1[i-n];
        }

        int k=0; // new nums1 pointer
        int i=n; // nums1 pointer
        int j=0; // nums2 pointer

        while(k<m+n){
            if(i>=m+n){
                //num1的元素比较完毕
                nums1[k++] = nums2[j++];
            }else if(j>=n){
                //num2的元素比较完毕
                nums1[k++] = nums1[i++];
            }else if(nums1[i]>=nums2[j]){
                nums1[k++] = nums2[j++];
            }else{
                nums1[k++] = nums1[i++];
            }
        }
    }

    public static void main(String[] args) {

    }
}
