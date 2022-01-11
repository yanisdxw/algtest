package com.nowcoder.hj;

import java.util.*;

public class HJ8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 输出结果要求有序！
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            for(int i = 0; i < n; ++i){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a,map.getOrDefault(a,0) + b);
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}
