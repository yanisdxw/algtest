package com.nowcoder.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Set<Character> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1;i>=0;i--){
            Character c = input.charAt(i);
            if(!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }
        System.out.println(sb);
    }
}
