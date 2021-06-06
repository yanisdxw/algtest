package com.leetcode.p_greedy;

import com.leetcode.Utils;

import java.util.*;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        //首先按照末尾排序：
        if(intervals.length==0 || intervals.length==1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //防止测试用例数据越界，不能用o1-o2
                return Integer.compare(o1[0], o2[0]);
            }
        });
        //prev为左边区间最大值
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = deque.pop();
            int[] interval = intervals[i];
            //prev左边一定小于interval左边，无需判断
            //prev右边小于interval左边
            if(prev[1]<interval[0]){
                //不合并
                deque.push(prev);
                deque.push(interval);
            } else if(prev[1]>=interval[0] && prev[1]<=interval[1]){
                //prev右边在interval区间内
                //合并
                int[] union = new int[]{prev[0], interval[1]};
                deque.push(union);
            } else {
                //prev完全包含interval
                deque.push(prev);
            }
        }
        int[][] ans = new int[deque.size()][2];
        int pos = 0;
        while (!deque.isEmpty()){
            ans[pos++] = deque.removeLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{8,10},{9,18},{1,4},{2,6}};
        int[][] ans = new Solution56().merge(nums);
        Utils.printArray(ans);
    }
}
