package com.nowcoder.hj;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            int sum = 0; int m = 0;
            int n = input.length();
            for(int i=n-1;i>=2;i--){
                Character c = input.charAt(i);
                int r = changeToInt(c);
                sum += r*(int)Math.pow(16,m);
                m++;
            }
            System.out.println(sum);
        }
        //System.out.println(Integer.parseInt("A",16));
    }

    public static int changeToInt(Character c){
        int res = 0;
        switch(c){
            case 'A': res=10; break;
            case 'B': res=11; break;
            case 'C': res=12; break;
            case 'D': res=13; break;
            case 'E': res=14; break;
            case 'F': res=15; break;
            default: res=Integer.parseInt(String.valueOf(c));break;
        }
        return res;
    }
}
