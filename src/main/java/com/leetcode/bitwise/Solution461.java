package com.leetcode.bitwise;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        while (res!=0){
            res &= (res-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = new Solution461().hammingDistance(1,3);
        System.out.println(ans);
    }
}
