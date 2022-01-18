package com.algorithm.discretization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.acwing.com/problem/content/804/
 */
public class 区间和 {

    private static List<Long> alls = new ArrayList();
    private static List<Pair<Long,Integer>> adds = new ArrayList();
    private static List<Pair<Long,Long>> query = new ArrayList();

    /**
     * 离散化思想
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0;i<n;i++){
            long x = sc.nextInt();
            int c = sc.nextInt();
            alls.add(x);
            adds.add(new Pair(x,c));
        }

        for(int i=0;i<m;i++){
            long l = sc.nextInt();
            long r = sc.nextInt();
            alls.add(l);
            alls.add(r);
            query.add(new Pair(l,r));
        }
        //去重+排序
        alls = alls.stream().distinct().sorted().collect(Collectors.toList());
        //构建数组
        int[] a = new int[alls.size()+1];
        for(Pair p:adds){
            int k = find((long) p.left);
            //同一个位置可能加多次
            a[k] += (int) p.right;
        }
        //求前缀和
        int[] s = new int[alls.size()+1];
        for(int i=1;i<=alls.size();i++){
            s[i] = s[i-1] + a[i];
        }
        for(Pair p:query){
            int l = find((long)p.left); int r = find((long)p.right);
            System.out.println(s[r] - s[l-1]);
        }
    }

    //第几个数而不是下标，所以是r+1
    private static int find(long x){
        int l = 0; int r = alls.size()-1;
        while(l<r){
            int mid = l+r>>>1;
            if(alls.get(mid)>=x){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r+1;
    }

    static class Pair<L,R> {
        public L left;
        public R right;
        public Pair(L left, R right){
            this.left = left;
            this.right = right;
        }
    }
}
