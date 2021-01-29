package com.leetcode;

import java.util.Arrays;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }
        int n = A.length;
        //设dp[i]为以i结尾的数组最大的等差数列个数
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        for(int i=3;i<=n;i++){
            dp[i] = (A[i-1]-A[i-2]==A[i-2]-A[i-3]?dp[i-1]+1:0);
        }
        //最终结果是把所有dp的值加起来
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans += dp[i];
        }
        return ans;
    }
}
