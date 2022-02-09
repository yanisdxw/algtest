package com.algorithm.cal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高精度乘法 {

    private static List<Integer> mul(List<Integer> vec, int b){
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < vec.size()||t!=0; i++) {
            if(i<vec.size()) t += vec.get(i)*b;
            res.add(t%10);
            t /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String as = sc.next();
        List<Integer> vec = new ArrayList<>();
        for (int i = as.length()-1; i >=0; i--) {
            vec.add(as.charAt(i)-'0');
        }
        int b = sc.nextInt();
        if(b==0){
            System.out.print(0);
            return;
        }
        List<Integer> res = mul(vec,b);
        for (int i = res.size()-1; i>=0; i--) {
            System.out.print(res.get(i));
        }
    }
}
