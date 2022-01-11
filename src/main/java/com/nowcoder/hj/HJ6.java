package com.nowcoder.hj;

import java.util.Scanner;

// 180 /2 90
//  90 /2 45
//  45 /3 15
//  15 /3 5
//   5 /5 1


public class HJ6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        int m = 2;
        while(input!=1){
            input = input/m;
            int n = input%m;
            //不能整除
            if(n!=0){
                m++;
            }else{
                System.out.print(m+" ");
            }
        }
    }
}
