package com.interview.recursive.leetcode_17;

import java.util.*;

public class leetocde_17 {
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits==""){
            return res;
        }
        findCombination(digits,0,"");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = Mapping.get(c);
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits,index+1,s+letters.charAt(i));
        }
        return;
    }

    static Map<Character, String> Mapping = new HashMap<>();
    private ArrayList<String> res;
    static {
        Mapping.put('2',"abc");
        Mapping.put('3',"def");
        Mapping.put('4',"ghi");
        Mapping.put('5',"jkl");
        Mapping.put('6',"mno");
        Mapping.put('7',"pqrs");
        Mapping.put('8',"tuv");
        Mapping.put('9',"wxyz");
    }

}
