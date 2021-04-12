package com.leetcode.p_dfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
public class Solution90 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //深度优先遍历，ans存储所有遍历的元素
        Arrays.sort(nums);
        dfs(0, nums);
        return ans;
    }

    //遍历获取所有包含num[pos]的数组并放入ans中
    private void dfs(int pos, int[] nums){
        ans.add(new ArrayList<Integer>(path));
        for (int i = pos; i < nums.length; i++) {
            //如果与前一个元素相同，则不加入到path中
            if(i!=pos && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            dfs(i+1, nums);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,1,2,2};
        List<List<Integer>> ans = new Solution90().subsetsWithDup(input);
        System.out.println(ans);
    }
}


/**
 res = []
 path = []

 def backtrack(未探索区域, res, path):
    if path 满足条件:
         res.add(path) # 深度拷贝
        # return  # 如果不用继续搜索需要 return
    for 选择 in 未探索区域当前可能的选择:
         if 当前选择符合要求:
         path.add(当前选择)
         backtrack(新的未探索区域, res, path)
         path.pop()

 作者：fuxuemingzhu
 链接：https://leetcode-cn.com/problems/subsets-ii/solution/hui-su-fa-mo-ban-tao-lu-jian-hua-xie-fa-y4evs/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/