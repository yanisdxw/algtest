package com.interview.array.leetcode_76;

import java.util.HashMap;
import java.util.Map;

/**
 * 题意是找到str中最短的substring，它里面与t的所有字母对应的数量更多。
 * 比如t里面有3个A，那么substring里面至少有3个A。
 * 第一步，数一下t里面每个字母出现了多少次。
 * 第二步，move end point，找到str中满足条件的字符串。就是刚好减掉了n个，n是t的长度。
 * 第三步，move start point，去夹逼最小的substring，意思就是move start到不能往右移为止，多移一位substring就不满足条件。
 * 第四步，比较长度。
 * 第五步，把start右移一位，让substring不满足条件。
 * 回到第二步。
 */

public class leetcode_76 {
    public static String minWindow(String s, String t) {

        if(s==null||s.isEmpty()||t==null||t.isEmpty()) return "";

        int i=0, j=0;
        int[] tmap=new int[256];
        int[] smap=new int[256];

        for(int k=0; k< t.length(); k++){
            tmap[t.charAt(k)]++;
        }

        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";

        while(j<s.length()){
            if(found<t.length()){
                //如果s[j]元素在t中
                if(tmap[s.charAt(j)]>0){
                    smap[s.charAt(j)]++;
                    if(smap[s.charAt(j)]<=tmap[s.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            //move start到不能往右移为止,多移一位substring就不满足条件。
            while(found==t.length()){
                if(j-i<length){
                    length=j-i;
                    res=s.substring(i,j);
                }
                //如果s[i]元素在t中
                if(tmap[s.charAt(i)]>0){
                    smap[s.charAt(i)]--;
                    if(smap[s.charAt(i)]<tmap[s.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s,t);
        System.out.println(res);
    }

}
