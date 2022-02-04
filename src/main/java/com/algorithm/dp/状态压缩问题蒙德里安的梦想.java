package com.algorithm.dp;

import com.leetcode.Utils;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/293/
 */
public class 状态压缩问题蒙德里安的梦想 {

    private static int N = 12;
    private static int M = 1<<N;

    private static long[][] f = new long[N][M];
    private static int n = 0;
    private static int m = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n==0 && m==0) break;
            boolean[] st = new boolean[1<<n];
            for(int i=0; i< 1<<n; i++){
                int cnt =0 ;//记录连续的0的个数
                boolean isValid = true; // 某种状态没有奇数个连续的0则标记为true
                for(int j=0;j<n;j++){ //遍历这一列，从上到下
                    if( (i>>j &1)!=0){  //i>>j位运算，表示i（i在此处是一种状态）的二进制数的第j位； &1为判断该位是否为1，如果为1进入if
                        if((cnt &1)!=0) { //这一位为1，看前面连续的0的个数，如果是奇数（cnt &1为真）则该状态不合法
                            isValid =false;break;
                        }
                        cnt=0; // 既然该位是1，并且前面不是奇数个0（经过上面的if判断），计数器清零。//其实清不清零没有影响
                    }
                    else cnt++; //否则的话该位还是0，则统计连续0的计数器++。
                }
                if((cnt &1)!=0)  isValid =false; //最下面的那一段判断一下连续的0的个数
                st[i]  = isValid; //状态i是否有奇数个连续的0的情况,输入到数组st中
            }

            f[0][0] = 1;
            for (int i = 1; i <= m; i ++)
                for (int j = 0; j < 1 << n; j ++)
                    for (int k = 0; k < 1 << n; k ++)
                        if ((j & k) == 0 && (st[j | k]))
                            // j & k == 0 表示 i 列和 i - 1列同一行不同时捅出来
                            // st[j | k] == 1 表示 在 i 列状态 j， i - 1 列状态 k 的情况下是合法的.
                            f[i][j] += f[i - 1][k];
            System.out.println(f[m][0]);
        }
    }

}
