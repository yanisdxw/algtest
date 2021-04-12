package com.leetcode.p_array;

import com.leetcode.Utils;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int cur = 0; //当前遍历的位置
        int pre = 0; //上一个位置正确的位置
        int times = 1; //cur遍历时当前值重复的个数
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[cur]){
                times++;

            }else {
                times=1;
            }
            cur++;
            if(cur-pre>=2){
                nums[pre+1] = nums[i];
            }
            if(times<=2){
                pre++;
            }
        }
        return pre+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int ans = new Solution80().removeDuplicates(nums);
        System.out.println(ans);
        Utils.printArray(nums);
        System.out.println();
        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};
        int ans1 = new Solution80().removeDuplicates(nums1);
        System.out.println(ans1);
        Utils.printArray(nums1);
    }
}
