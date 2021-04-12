package com.leetcode.p_math;

public class Solution69 {
    public int mySqrt(int x) {
        if(x==0) return x;
        long pow; int mid;
        int l = 1; int r = x;
        while(l<=r){
            mid = l + (r-l)/2;
            pow = mid * mid;
            if(pow==x){
                return mid;
            }else if(pow>x){
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int solution = new Solution69().mySqrt(81);
        System.out.println(solution);
    }
}
