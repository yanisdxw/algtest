package com.interview.dp;

public class bag {

    private int[][] memo;

    public int knapstack01(int[] w, int[] v, int C){
        int n = w.length;
        memo = new int[n][C+1];
        return bestValue(w,v,n-1,C);
    }
    //用[0...index] 的物品 填充容积为c的背包的最大值
    private int bestValue(int[] w, int[] v, int index, int c){
        if(index<0 || c<=0){
            return 0;
        }
        if(memo[index][c]!=-1){
            return memo[index][c];
        }
        int res = bestValue(w,v,index-1,c);
        if(c>=w[index]){
            res = Math.max(res,v[index] + bestValue(w,v,index-1,c-w[index]));
        }
        memo[index][c] = res;
        return res;
    }
}
