package com.leetcode;

import java.util.*;

import static com.leetcode.Utils.printArray;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        //这里使用桶排序解决这个问题。首先做一个频次表
        Map<Integer,Integer> counts = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            Integer count;
            if(counts.containsKey(nums[i])){
                count = counts.get(nums[i])+1;
            }else {
                count = 1;
            }
            counts.put(nums[i],count);
            max = Math.max(count, max);
        }
        //再进行一个桶排序，这次做一个频次的频次表
        int[][] freq = new int[max+1][0];
        for(Map.Entry<Integer,Integer> entry:counts.entrySet()){
            Integer f = entry.getValue();
            Integer v = entry.getKey();
            int[] n = freq[f];
            //注意这里数组扩容的方式，在原长度上+1
            n = Arrays.copyOf(n, n.length+1);
            n[n.length-1] = v;
            freq[f] = n;
        }
        int c = 0; int[] rst = new int[k];
        for (int i = max; i >=0; i--) {
            int[] m = freq[i];
            for (int j = 0; j < m.length; j++) {
                rst[c++] = m[j];
            }
            if(c==k) return rst;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3}; int k = 2;
        int[] rst = new Solution347().topKFrequent(nums, k);
        printArray(rst);
    }
}
