package com.interview.array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_169 {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }else{
                map.put(nums[i],1);
            }
        }
        return -1;
    }
}
