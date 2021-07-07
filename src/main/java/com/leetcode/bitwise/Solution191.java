package com.leetcode.bitwise;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        //int 32位，所以右移32位
        for (int i = 0; i < 32; i++) {
            ans += n&1;
            n>>=1;
        }
        return ans;
    }

    /**
     * 算术右移 >> ：舍弃最低位，高位用符号位填补；
     * 逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int ans = 0;
        //int 32位，所以右移32位
        //那么对于负数而言，其二进制最高位是 1，如果使用算术右移，那么高位填补的仍然是 1。
        //所以java这里要用>>>
        while (n!=0){
            ans += n&1;
            n>>>=1;
        }
        return ans;
    }


    public int hammingWeight3(int n) {
        int ans = 0;
        // n & (n - 1) ，这个代码可以把 n 的二进制中，最后一个出现的 1 改写成 0。
        // 比如 10 --> 1010 -->  c(10) = 2
        //      8  --> 1000 -->  c(8) = 1
        //      0  --> 0000 -->  c(0) = 0
        while (n!=0){
            ans += 1;
            n&=(n-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Solution191().hammingWeight3(10);
    }
}
