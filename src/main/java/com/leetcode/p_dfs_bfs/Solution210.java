package com.leetcode.p_dfs_bfs;

import com.leetcode.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] course = prerequisites[i];
            //要学习course[0],必须先学习course[1]
            in[course[0]]++;
        }
        //queue只有入度为0的课程
        Queue<Integer> queue = new LinkedList<>();
        //入度为0的课程入列
        for (int i = 0; i < in.length; i++) {
            if(in[i]==0){
                queue.add(i);
            }
        }
        //BFS遍历入度为0的课程
        int[] ret = new int[numCourses];
        int pos = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            ret[pos++] = course;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1]==course){
                    in[prerequisites[i][0]]--;
                    if(in[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        //判断为否有环：既in数组是否都为0
        for (int i = 0; i < in.length; i++) {
            if(in[i]!=0){
                return new int[]{};
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] ret = new Solution210().findOrder(numCourses, prerequisites);
        Utils.printArray(ret);
    }
}
