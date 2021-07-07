package com.leetcode.p_dp;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution96 {

    /**
     * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，
     * 右子树节点为n-2，所以可得G(n) = G(0)*G(n-1) + G(1)*G(n-2)+...+ G(n-1)*G(0)
     *** 注意到 G(n)G(n) 和序列的内容无关，只和序列的长度有关
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        // G(n) = sum(i=1,n)G(i-1)*G(n-i)
        // i充当了n的位置
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j <=i ; j++) {
                //g[j-i]:左序列构建左子树
                //g[i-j]:右序列构建由子树
                g[i] += g[j-1]*g[i-j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        int ans = new Solution96().numTrees(3);
        System.out.println(ans);
    }
}
