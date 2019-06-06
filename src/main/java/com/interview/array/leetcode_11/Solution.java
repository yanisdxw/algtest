package com.interview.array.leetcode_11;


/**
 * 给定 n 个非负整数 a1，a2，…，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l=0,r=height.length-1;
        while (l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            if(area>maxArea){
                maxArea = area;
            }
            if(height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }
        return maxArea;
    }
}
