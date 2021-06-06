package com.leetcode.p_array;

import com.leetcode.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * 示例 2：
 *
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 */
public class Solution406 {

    //贪心算法：按照身高从高到低进行排序，矮的放后面，因为矮的即使放在了高的前面，
    //也不会对之前高的产生影响；但高的放在前面，对矮的结果就会产生影响了。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2)->{
            if(p1[0]!=p2[0]){
                return p2[0]-p1[0];
            }else {
                return p1[1]-p2[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int[] p:people){
            res.add(p[1],p);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] ans = new Solution406().reconstructQueue(people);
        Utils.printArray(ans);
    }
}
