package com.interview.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindCoin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        int coinnum[] = new int[6];
        for (int i=0; i<6; i++){
            coinnum[i]=input.nextInt();
        }
        solve(sum,coinnum);
    }

    //硬币面值
    static int coin[]={1,5,10,50,100,500};
    //贪心算法
    //coinnum是每种硬币个数
    public static void solve(int sum, int coinnum[]){
        int ans = 0;
        for(int i=5; i>=0; i--){
            int n = Math.min(sum/coin[i],coinnum[i]);
            sum = sum - n * coin[i];
            ans += n;
        }
        System.out.println(ans);
    }
}
