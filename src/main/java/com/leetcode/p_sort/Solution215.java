package com.leetcode.p_sort;

import static com.leetcode.Utils.printArray;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0; int r = nums.length - 1; int p=0;
        while(l<=r){
            p = partition(nums,l,r);
            if(p==k-1) {
                return nums[p];
            } else if(p>k-1){
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return nums[p];
    }

//     public int partition(int[] nums, int left, int right) {
//         int pivot = left;
//         int l = left + 1; //记住这里l是left + 1
//         int r = right;
//         while (l <= r) {
//             while (l <= r && nums[l] >= nums[pivot]) l++; //从左边找到第一个小于nums[pivot]的数
//             while (l <= r && nums[r] <= nums[pivot]) r--; //从右边找到第一个大于nums[pivot]的数
//             if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
//                 swap(nums, l++, r--);
//             }
//         }
//         swap(nums, pivot, r); //交换pivot到它所属的最终位置，也就是在r的位置，因为此时r的左边都比r大，右边都比r小
//         return r; //返回最终pivot的位置
//     }

    public int partition(int[] nums, int left, int right){
        int v = nums[left];
        int j = left;
        for(int i=left+1; i<right; i++){
            if(nums[i]<v){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,left);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4,5};
        int p = new Solution215().partition(nums,0,nums.length-1);
        System.out.println(p);
        printArray(nums);
    }
}
