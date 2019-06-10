package com.interview.greedy.leetcode_435;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[1] - a2[1];
            }
        });

        //dp[i]表示使用intervals[0...i]的区间能构成的最长不重叠区间序列
        int[] dp = new int[intervals.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < intervals.length; i++) {
            //dp[i]
            for (int j = 0; j < i; j++) {
                //前面的结尾越小 留给后面的空间越大
                if(intervals[i][0]>=intervals[j][1]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return intervals.length - res;
    }

    public static void main(String[] args) {
        int a[][] = {{1,3},{4,5},{2,3}};
        Arrays.sort(a,new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[1] - a2[1];
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
        }
    }
}
