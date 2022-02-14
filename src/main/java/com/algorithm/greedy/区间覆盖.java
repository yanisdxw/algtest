
package com.algorithm.greedy;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/909/
 */
public class 区间覆盖 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        int ed = sc.nextInt();
        int n = sc.nextInt();
        List<Range> ranges = new ArrayList();
        for(int i=0;i<n;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            ranges.add(new Range(l,r));
        }
        Collections.sort(ranges, new Comparator<Range>(){
            @Override
            public int compare(Range o1, Range o2){
                return o1.l-o2.l;
            }
        });
        int res = 0; boolean success = false;
        for(int i=0;i<n;i++){
            Range range = ranges.get(i);
            int j = i; int r = (int) -2e10;
            while(j<n && ranges.get(j).l<=st){
                r = Math.max(r, ranges.get(j).r);
                j++;
            }
            if(r<st){
                res = -1;
                break;
            }
            res++;
            if(r>=ed){
                success = true;
                break;
            }
            st = r;
            i = j-1;
        }
        if(!success){
            System.out.print(-1);
        }else{
            System.out.print(res);
        }
    }
}
