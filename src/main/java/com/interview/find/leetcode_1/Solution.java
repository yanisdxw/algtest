package com.interview.find.leetcode_1;


import java.util.*;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int aux = target - nums[i];
            if(map.containsKey(aux)){
                return new int[]{i,map.get(aux)};
            }
            map.put(target - nums[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

    }
}
