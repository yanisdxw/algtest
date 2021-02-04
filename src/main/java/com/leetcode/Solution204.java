package com.leetcode;

import java.util.Arrays;

public class Solution204 {

    /**
     * 艾氏筛除法：从1到n遍历，假设遍历到m，则把所有小于n的，且是m的倍数的数标记为合数；
     * 遍历完，没有被标记为合数的就是质数
     */

    public int countPrimes(int n) {
        //考虑特殊情况
        if(n<2){
            return 0;
        }
        //艾氏筛除法
        boolean[] prime = new boolean[n+1];
        //一开始所有数都假设为质数
        Arrays.fill(prime, true);
        //但0和1不是质数
        int count = n-2;
        //从2开始遍历到n
        for(int i=2;i<=n;i++){
            if(prime[i]){
                for(int j=2*i;j<n;j+=i){
                    prime[j] = false;
                }
            }else{
                count--;
            }
        }
        return count;
    }
}
