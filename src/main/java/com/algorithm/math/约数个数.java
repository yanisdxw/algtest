package com.algorithm.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 约数个数 {

    private static final int mod = (int) 1e9+7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        while (n-->0){
            int x = sc.nextInt();
            for (int i = 2; i <= x/i; i++) {
                while (x%i==0){
                    int o = map.getOrDefault(i,0);
                    map.put(i,o+1);
                    x /= i;
                }
            }
            if(x>1) {
                int o = map.getOrDefault(x,0);
                map.put(x,o+1);
            }
        }
        long res = 1L;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int v = entry.getValue();
            res = res*(v+1)%mod;
        }
        System.out.println(res);
    }
}
