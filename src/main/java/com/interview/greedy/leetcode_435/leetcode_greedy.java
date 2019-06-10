package com.interview.greedy.leetcode_435;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_greedy {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[1]!=a2[1]){
                    return a1[1] - a2[1];
                }
                return a1[0] - a2[0];
            }
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=intervals[pre][1]){
                res ++;
                pre = i;
            }
        }

        return intervals.length - res;
    }
}
