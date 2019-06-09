package com.interview.dp.leetcode_198;

import java.util.Arrays;

public class leetcode_198 {
//    //memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
//    private int[] memo;
//
//    // 考虑抢劫 nums[index...nums.size()) 这个范围的所有房子
//    private int tryRob(int[] nums, int index){
//        if(index==nums.length){
//            return 0;
//        }
//
//        if(memo[index]!=-1){
//            return memo[index];
//        }
//
//        int res = 0;
//        for (int i = index; i < nums.length; i++) {
//            res = Math.max(res,nums[i] + tryRob(nums,i+2));
//        }
//        memo[index] = res;
//        return res;
//    }
//
//    public int rob(int[] nums) {
//        memo = new int[nums.length+1];
//        Arrays.fill(memo,-1);
//        return tryRob(nums,0);
//    }


    public int rob(int[] nums) {
        int n = nums.length;

        if(n==0){
            return 0;
        }

        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        memo[n-1] = nums[n-1];
        for (int i = n-2; i >=0 ; i--) {
            //memo[i]
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j+2<n ? memo[j+2]:0));
            }
        }
        return memo[0];
    }

}
