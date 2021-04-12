package com.leetcode.p_greedy;

import com.leetcode.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length<=1){
            return points.length;
        }
        //将数组按末尾排序，然后遍历，看与前一个是否相交，
        //如果不相交就+1
        //首先按照末尾排序：
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //防止测试用例数据越界，不能用o1-o2
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int ans = 1; int[] prev = points[0];
        for (int i = 1; i < points.length; i++) {
            //如果不相交，+1
            int[] cur = points[i];
            if(cur[0]>prev[1]){
                ans++;
                prev = cur;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3},{2,4},{1,2}};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Utils.printArray(points);
    }

}
