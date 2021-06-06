package com.leetcode.p_greedy;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 提示：
 * 1 <= num <= 3999
 */
public class Solution12 {
    /**
     *     public String intToRoman(int num) {
     *         StringBuilder sb = new StringBuilder();
     *         //计算num由几个千、百、十、一组成，分别获取4位的表示，然后加起来
     *         int m4 = num/1000;
     *         num %= 1000;
     *         int m3 = num/100;
     *         num %= 100;
     *         int m2 = num/10;
     *         num %= 10;
     *         int m1 = num/1;
     *
     *         //千位字符判断
     *         switch (m4){
     *             case 1: sb.append("M"); break;
     *             case 2: sb.append("MM"); break;
     *             case 3: sb.append("MMM"); break;
     *             default: break;
     *         }
     *         //百位字符判断
     *         switch (m3){
     *             case 1: sb.append("C"); break;
     *             case 2: sb.append("CC"); break;
     *             case 3: sb.append("CCC"); break;
     *             case 4: sb.append("CD"); break;
     *             case 5: sb.append("D"); break;
     *             case 6: sb.append("DC"); break;
     *             case 7: sb.append("DCC"); break;
     *             case 8: sb.append("DCCC"); break;
     *             case 9: sb.append("CM"); break;
     *             default: break;
     *         }
     *         //十位字符判断
     *         switch (m2){
     *             case 1: sb.append("X"); break;
     *             case 2: sb.append("XX"); break;
     *             case 3: sb.append("XXX"); break;
     *             case 4: sb.append("XL"); break;
     *             case 5: sb.append("L"); break;
     *             case 6: sb.append("LX"); break;
     *             case 7: sb.append("LXX"); break;
     *             case 8: sb.append("LXXX"); break;
     *             case 9: sb.append("XC"); break;
     *             default: break;
     *         }
     *         //个位字符判断
     *         switch (m1){
     *             case 1: sb.append("I"); break;
     *             case 2: sb.append("II"); break;
     *             case 3: sb.append("III"); break;
     *             case 4: sb.append("IV"); break;
     *             case 5: sb.append("V"); break;
     *             case 6: sb.append("VI"); break;
     *             case 7: sb.append("VII"); break;
     *             case 8: sb.append("VIII"); break;
     *             case 9: sb.append("IX"); break;
     *             default: break;
     *         }
     *         return sb.toString();
     *     }
     */

    //这道题使用贪心算法的直觉来源是：尽可能优先使用较大数值对应的字符，最后转换得到的罗马数字的字符个数更少
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        String ans = new Solution12().intToRoman(58);
        System.out.println(ans);
    }
}
