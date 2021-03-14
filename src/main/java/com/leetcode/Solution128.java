package com.leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size()==1) return 1;
        Iterator<Integer> iterator = set.iterator();
        int ans = 0;
        int local_len = 1;
        int prev = iterator.next();
        while (iterator.hasNext()){
            int cur = iterator.next();
            if(cur==prev+1){
                local_len++;
            }else {
                local_len=1;
            }
            prev = cur;
            ans = Math.max(ans,local_len);
        }
        return ans;
    }
}
