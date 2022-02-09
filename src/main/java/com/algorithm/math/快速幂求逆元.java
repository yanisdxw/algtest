package com.algorithm.math;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/878/
 */
public class 快速幂求逆元 {
    private static long qmi(long a, long k, long p){
        long res = 1L%p;
        while(k!=0){
            if((k&1)==1) res=res*a%p;
            k>>=1;
            a = a*a%p;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            long a = sc.nextLong();
            long p = sc.nextLong();
            if(a%p==0) {
                System.out.println("impossible");
            }else {
                //费马定理：
                //如果p是质数，a不是p的倍数，有a^(p-1) ≡ 1 (mod p)
//                当n为质数时，可以用快速幂求逆元：
//                a / b ≡ a * x (mod n)
//                两边同乘b可得 a ≡ a * b * x (mod n)
//                即 1 ≡ b * x (mod n)
//                同 b * x ≡ 1 (mod n)
//                由费马小定理可知，当n为质数时
//                b ^ (n - 1) ≡ 1 (mod n)
//                拆一个b出来可得 b * b ^ (n - 2) ≡ 1 (mod n)
//                故当n为质数时，b的乘法逆元 x = b ^ (n - 2)
                System.out.println(qmi(a,p-2,p));
            }
        }
    }
}
