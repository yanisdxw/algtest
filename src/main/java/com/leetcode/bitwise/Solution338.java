package com.leetcode.bitwise;

import com.leetcode.Utils;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class Solution338 {
    /**
     *     public int[] countBits(int num) {
     *         int[] result = new int[num+1];
     *         for (int i = 0; i <= num; i++) {
     *             result[i] = count(i);
     *         }
     *         return result;
     *     }
     *
     *     //计算一个数二进制1的个数
     *     //对于任意整数x, 令x = x&(x-1),
     *     //该运算将 xx 的二进制表示的最后一个1变成0
     *     private int count(int num){
     *         int count = 0;
     *         while (num!=0){
     *             num &= (num-1);
     *             count++;
     *         }
     *         return count;
     *     }
     */

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            // i&(i-1) 比 i 少一个1
            result[i] = result[i&(i-1)] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 8;
        int[] ans = new Solution338().countBits(num);
        Utils.printArray(ans);
    }
}
