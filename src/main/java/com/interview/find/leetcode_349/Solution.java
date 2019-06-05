package com.interview.find.leetcode_349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                resSet.add(nums2[i]);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        Iterator itSet = resSet.iterator();
        while (itSet.hasNext()){
            res[i++] = (int) itSet.next();
        }
        return res;
    }
}
