package com.dxw.SegmentTree.leetcode_303;

import com.dxw.SegmentTree.SegmentTree;

/**
 * leetocde 303
 */
class NumArray {

    //private ArrayList<Integer> arrayList = new ArrayList<>();
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length>0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public int sumRange(int i, int j) {
        if(segmentTree==null){
            throw new IllegalArgumentException("null");
        }
        return segmentTree.query(i,j);
    }

    public static void main(String[] args) {

    }
}