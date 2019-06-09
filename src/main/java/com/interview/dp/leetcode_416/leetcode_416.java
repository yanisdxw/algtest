package com.interview.dp.leetcode_416;

public class leetcode_416 {
    // memo[i][c] 表示使用索引为[0...i]的这些元素 是否可以完全填充一个容量为c的背包
    //-1为未计算 0 不可填充 1 可以填充
    private int[][] memo;

    private boolean tryPartition(int[] nums, int index, int sum){
        if(sum==0){
            return true;
        }

        if(sum<0 || index<0){
            return false;
        }

        if(memo[index][sum]!=-1){
            return memo[index][sum]==1;
        }

        memo[index][sum] = (tryPartition(nums,index-1,sum) ||
                tryPartition(nums,index-1,sum-nums[index])) ? 1:0;

        return memo[index][sum]==1;

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        memo = new int[nums.length][sum/2 + 1];
        return tryPartition(nums, nums.length-1, sum/2);
    }
}
