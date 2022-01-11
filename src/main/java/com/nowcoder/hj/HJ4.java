package com.nowcoder.hj;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //多组输入
        while (sc.hasNext()){
            String s = sc.nextLine();
            //8的整数倍
            int n = s.length()/8;
            int m = s.length()%8;
            for (int i = 0; i < n; i++) {
                System.out.println(s.substring(8*(i),8*(i+1)));
            }
            if(m!=0){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 8-m; i++) {
                    sb.append("0");
                }
                System.out.println(s.substring(8*n)+sb);
            }
        }
    }
}
