package com.leetcode.p_2pointer;

import static com.leetcode.Utils.printArray;
import static com.leetcode.Utils.swap;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        //双指针p0，p1：p0指0的位置，p1指1的位置
        int p0=0; int p1=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                swap(p1,i,nums);
                p1++;
            }else if(nums[i]==0){
                swap(p0,i,nums);
                //p0的位置小于p1的位置，说明之前有1被交换到了此时p0的位置
                //所以需要把之前交换到p0位置的1（此时已经在i的位置上了）
                //再交换到p1指针的位置
                if(p0<p1){
                    swap(p1,i,nums);
                }
                p0++;
                p1++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new Solution75().sortColors(nums);
        printArray(nums);
    }
}
