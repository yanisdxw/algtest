package com.leetcode.p_dp;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 */
public class Solution494 {

    /** 暴力dfs
     *    int count = 0;
     *
     *     public int findTargetSumWays(int[] nums, int target) {
     *         dfs(0,nums,target);
     *         return count;
     *     }
     *
     *     private void dfs(int start, int[] nums, int target){
     *         if(start==nums.length-1){
     *             if(nums[start]==0 && target==0){
     *                 count += 2;
     *             }else if (target==nums[start] || -target==nums[start]){
     *                 count++;
     *             }
     *             return;
     *         }
     *         dfs(start+1, nums, target+nums[start]);
     *         dfs(start+1, nums, target-nums[start]);
     *     }
     *
     */

    //dp背包问题

    /**
     * 01背包问题是选或者不选，但本题是必须选，是选+还是选-。先将本问题转换为01背包问题。
     * 假设所有符号为+的元素和为x，符号为-的元素和的绝对值是y。
     * 我们想要的 S = 正数和 - 负数和 = x - y
     * 而已知x与y的和是数组总和：x + y = sum
     * 可以求出 x = (S + sum) / 2 = target
     * 也就是我们要从nums数组里选出几个数，令其和为target
     * 于是就转化成了求容量为target的01背包问题 =>要装满容量为target的背包，有几种方案
     *
     * 作者：edelweisskoko
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/494-mu-biao-he-dong-tai-gui-hua-zhi-01be-78ll/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num:nums) sum+=num;
        // targrt = x - y
        // sum = x + y
        // S = x
        if(target>sum || (target + sum) % 2 == 1) return 0;
        int S = (target + sum)/2;
        //dp[j]代表的意义：填满容量为j的背包，有dp[j]种方法。因为填满容量为0的背包有且只有一种方法，所以dp[0] = 1
        int[] dp = new int[S+1];
        dp[0] = 1;
        for(int num:nums){
            for (int i = S; i >=num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[S];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int ans = new Solution494().findTargetSumWays(nums,3);
        System.out.println(ans);
    }
}
