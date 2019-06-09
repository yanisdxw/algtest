package com.interview.dp.leetocde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] min = new int[n+1];
        //min1表示加上下层较小值之后的值， 每层更新一边， 有效长度缩小 1 位
        for(int level = n-1; level >=0; level--){
            for(int i = 0; i< triangle.get(level).size(); i++){
                //从最后一行向上加，上一层元素从它相邻的两个下层元素中选择较小的那个加到它本身。
                min[i] = Math.min(min[i],min[i+1]) + triangle.get(level).get(i);
            }
            System.out.print("value min in level "+level+": ");
            for (int i = 0; i < min.length; i++) {
                System.out.print(min[i]+" ");
            }
            System.out.println();
        }
        return min[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[] level1 = new Integer[]{2};
        Integer[] level2 = new Integer[]{3,4};
        Integer[] level3 = new Integer[]{6,5,7};
        Integer[] level4 = new Integer[]{4,1,8,3};
        ArrayList a1 = new ArrayList(Arrays.asList(level1));
        ArrayList a2 = new ArrayList(Arrays.asList(level2));
        ArrayList a3 = new ArrayList(Arrays.asList(level3));
        ArrayList a4 = new ArrayList(Arrays.asList(level4));
        triangle.add(a1);
        triangle.add(a2);
        triangle.add(a3);
        triangle.add(a4);

        int res = minimumTotal(triangle);
    }

}
