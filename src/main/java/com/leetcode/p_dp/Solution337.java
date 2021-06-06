package com.leetcode.p_dp;

import com.leetcode.po.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Solution337 {
    /**
     * 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱
     * 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构
     * @param root
     * @return
     */

    /** 递归解法
     *     public int rob(TreeNode root) {
     *         if(root==null){
     *             return 0;
     *         }
     *         //money为4 个孙子偷的钱 + 爷爷的钱
     *         int money = root.val;
     *         if(root.right!=null){
     *             money += (rob(root.right.right) + rob(root.right.left));
     *         }
     *         if(root.left!=null){
     *             money += (rob(root.left.right) + rob(root.left.left));
     *         }
     *         return Math.max(money, rob(root.left)+rob(root.right));
     *     }
     */

    /** 递归解法 + 备忘录
     *     private Map<TreeNode, Integer> memo = new HashMap<>();
     *
     *     public int rob(TreeNode root) {
     *         if(memo.containsKey(root)){
     *             return memo.get(root);
     *         }
     *         if(root==null){
     *              return 0;
     *          }
     *          //money为4 个孙子偷的钱 + 爷爷的钱
     *          int money = root.val;
     *          if(root.right!=null){
     *              money += (rob(root.right.right) + rob(root.right.left));
     *          }
     *          if(root.left!=null){
     *              money += (rob(root.left.right) + rob(root.left.left));
     *          }
     *          int result = Math.max(money, rob(root.left)+rob(root.right));
     *          memo.put(root, result);
     *          return result;
     *     }
     */

//    我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
//    任何一个节点能偷到的最大钱的状态可以定义为：
//      >当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
//      >当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数

    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0],result[1]);
    }

    private int[] helper(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        result[0] = Math.max(left[1], left[0]) + Math.max(right[0],right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
