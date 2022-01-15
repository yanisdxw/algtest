package com.nowcoder.hj;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        int res = 0;
        while(input!=0){
            res += input&1;
            input = input>>>1;
        }
        System.out.print(res);
    }
}
