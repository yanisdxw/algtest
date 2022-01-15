package com.nowcoder.hj;

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1;i>=0;i--){
            sb.append(input.charAt(i));
        }
        System.out.print(sb);
    }
}
