package com.leetcode.p_2pointer;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
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
