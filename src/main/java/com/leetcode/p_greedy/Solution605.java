package com.leetcode.p_greedy;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = maxCanPlace(flowerbed);
        return n<=max;
    }

    private int maxCanPlace(int[] flowerbed){
        if(flowerbed.length==1){
            return flowerbed[0]==0?1:0;
        }
        int max = 0;
        for (int i = 0; i < flowerbed.length; ) {
            if(i==0){
                if(flowerbed[i]==0 && flowerbed[i+1]==0){
                    max++;
                    i=i+2;
                }else {
                    i++;
                }
                continue;
            }
            if(i==flowerbed.length-1){
                if(flowerbed[i]==0 && flowerbed[i-1]==0){
                    max++;
                    i=i+2;
                }else {
                    i++;
                }
                continue;
            }
            if(flowerbed[i]!=1 && flowerbed[i-1]!=1 && flowerbed[i+1]!=1){
                max++;
                i=i+2;
                continue;
            }
            i++;
        }
        return max;
    }

    //改变原数组，但更简洁的解法
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            //判断当前位置能否种花
            //能种 ❀ 的情况
            if (flowerbed[i] == 0
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)
                    && (i == 0 || flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1;
                ans++;
            }
        }
        return ans >= n;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1};
        int ans = new Solution605().maxCanPlace(input);
        System.out.println(ans);
    }

}
