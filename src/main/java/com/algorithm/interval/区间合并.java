package com.algorithm.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/805/
 */
public class 区间合并 {
    private static List<Pair> merge(List<Pair> intervals){
        intervals.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int) (o1.left-o2.left);
            }
        });
        List<Pair> res = new ArrayList();
        Integer st = Integer.MIN_VALUE;
        Integer ed = Integer.MIN_VALUE;
        for(Pair interval:intervals){
            if(ed<interval.left){
                if(ed!=Integer.MIN_VALUE) res.add(new Pair(st,ed));
                st = interval.left; ed = interval.right;
            }else{
                ed = Math.max(ed, interval.right);
            }
        }
        if(st!=Integer.MIN_VALUE) res.add(new Pair(st,ed));
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> intervals = new ArrayList();
        for(int i=0;i<n;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            intervals.add(new Pair(l,r));
        }
        List<Pair> res = merge(intervals);
        System.out.print(res.size());
    }

    static class Pair{
        public Integer left;
        public Integer right;
        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
