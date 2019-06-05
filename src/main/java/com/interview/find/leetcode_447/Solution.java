package com.interview.find.leetcode_447;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i!=j){
                    if(record.containsKey(dis(points[i],points[j]))){
                        record.put(dis(points[i],points[j]),record.get(dis(points[i],points[j]))+1);
                    }else {
                        record.put(dis(points[i],points[j]),1);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
                if(entry.getValue()>=2){
                    res += entry.getValue()*(entry.getValue()-1);
                }
            }
        }
        return res;
    }

    private int dis(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
