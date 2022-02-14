package com.algorithm.greedy;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/907/
 * https://www.acwing.com/problem/content/910/
 */

public class 区间选点AND最大不相交区间数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            ranges.add(new Range(l,r));
        }
        Collections.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return o1.r-o2.r;
            }
        });
        int res = 0; int ed = (int)-1e10;
        for (int i = 0; i < n; i++) {
            Range range = ranges.get(i);
            if(range.l>ed){
                res++;
                ed = range.r;
            }
        }
        System.out.println(res);
    }
}

