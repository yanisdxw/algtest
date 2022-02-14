package com.algorithm.greedy;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/908/
 */

public class 区间分组 {
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
                return o1.l-o2.l;
            }
        });
        //和最小组的右端点比较，所以用小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Range range = ranges.get(i);
            if(heap.isEmpty()||heap.peek()>=range.l) {
                heap.add(range.r);
            }else {
                heap.poll();
                heap.add(range.r);
            }
        }
        System.out.println(heap.size());
    }
}



