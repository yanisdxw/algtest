package com.interview.dp.leetcode_416;

public class leetcode_416_dp {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            sum += nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        int n = nums.length;
        int c = sum/2;
        boolean[] dp = new boolean[c+1];

        //初始化 看第一个数能不能把背包填满
        for (int i = 0; i <=c ; i++) {
            dp[i] = ( nums[0] == i);
        }

        for (int i = 1; i <n ; i++) {
            for (int j = c; j >= nums[i] ; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[c];
    }
}
