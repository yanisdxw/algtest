package com.algorithm.math;

import java.util.*;

/**
 * https://www.acwing.com/problem/content/871/
 */
public class 试除法求约数 {
    private static List<Integer> getDivisor(int n){
        List<Integer> res = new ArrayList();
        for(int i=1;i<=n/i;i++){
            if(n%i==0){
                res.add(i);
                if(i!=n/i){
                    res.add(n/i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int a = sc.nextInt();
            List<Integer> res = getDivisor(a);
            for(Integer u:res){
                System.out.print(u+" ");
            }
            System.out.println();
        }
    }
}
