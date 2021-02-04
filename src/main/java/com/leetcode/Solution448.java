package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n+1];
        for(int i=1;i<=n;i++){
            flag[nums[i-1]] = true;
        }
        List<Integer> ans = new ArrayList();
        for(int i=1;i<=n;i++){
            if(!flag[i]) ans.add(i);
        }
        return ans;
    }
}
