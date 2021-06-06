package com.leetcode.p_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()){
            int course = queue.poll();
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
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        boolean ans = new Solution207().canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }
}
