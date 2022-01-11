package com.nowcoder.hj;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<Character> set = new HashSet();
        String input = sc.next();
        int res = 0;
        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            if(!set.contains(c)){
                res++;
                set.add(c);
            }
        }
        System.out.println(res);
    }
}
