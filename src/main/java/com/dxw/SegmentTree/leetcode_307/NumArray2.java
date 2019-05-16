package com.dxw.SegmentTree.leetcode_307;

import com.dxw.SegmentTree.SegmentTree;

public class NumArray2 {
    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if(nums.length>0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public void update(int index, int val){
        if(segmentTree==null){
            throw new IllegalArgumentException("null");
        }
        segmentTree.set(index,val);
    }

    public int sumRange(int i, int j) {
        if(segmentTree==null){
            throw new IllegalArgumentException("null");
        }
        return segmentTree.query(i,j);
    }
}
