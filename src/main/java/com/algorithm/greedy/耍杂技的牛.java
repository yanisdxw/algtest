package com.algorithm.greedy;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/127/
 */
public class 耍杂技的牛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Cow> cows = new ArrayList();
        for(int i=0;i<n;i++){
            int w = sc.nextInt();
            int s = sc.nextInt();
            cows.add(new Cow(w,s));
        }
        Collections.sort(cows, new Comparator<Cow>(){
            @Override
            public int compare(Cow o1, Cow o2){
                return o1.ws - o2.ws;
            }
        });
        int res = (int)-2e10; int sum = 0;
        for(int i=0;i<n;i++){
            Cow cow = cows.get(i);
            int w = cow.w;
            int s = cow.s;
            res = Math.max(res,sum-s);
            sum += w;
        }
        System.out.print(res);
    }
}

class Cow {
    int w;
    int s;
    int ws;
    public Cow(int w, int s){
        this.w = w;
        this.s = s;
        this.ws = w + s;
    }
}
