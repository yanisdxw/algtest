package com.nowcoder.hj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
        List<String> ls = new ArrayList();
        for(int i=0;i<n;i++){
            ls.add(sc.nextLine());
        }
        Collections.sort(ls);
        for(String s:ls){
            System.out.println(s);
        }
    }
}
