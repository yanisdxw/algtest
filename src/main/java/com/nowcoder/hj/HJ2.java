package com.nowcoder.hj;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase(Locale.ROOT);
        Character key = Character.toLowerCase(sc.next().charAt(0));
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        System.out.println(map.getOrDefault(key,0));
    }
}
