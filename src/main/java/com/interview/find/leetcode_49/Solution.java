package com.interview.find.leetcode_49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<Integer>> map = getStringsMap(strs);
        List<List<String>> res = new ArrayList<>();
        for(List<Integer> value:map.values()){
            List<String> list = new ArrayList<>();
            for(Integer e:value){
                list.add(strs[e]);
            }
            res.add(list);
        }
        return res;
    }

    private Map<Map<Character,Integer>,List<Integer>> getStringsMap(String[] strings){
        Map<Map<Character,Integer>,List<Integer>> mapListMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            Map<Character,Integer> map = help(strings[i]);
            if(mapListMap.containsKey(map)){
                ArrayList<Integer> list = (ArrayList<Integer>) mapListMap.get(map);
                list.add(i);
                mapListMap.put(map,list);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                mapListMap.put(map,list);
            }
        }
        return mapListMap;
    }

    private Map<Character,Integer> help(String s){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        return map;
    }
}
