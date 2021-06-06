package com.leetcode.p_map;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = getKey(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(key, strings);
            }
        }
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

//    private String getKey(String str){
//        char[] c = str.toCharArray();
//        Arrays.sort(c);
//        String key = String.valueOf(c);
//        return key;
//    }

    private String getKey(String str){
        char[] freq = new char[26];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            freq[c-97]++;
        }
        String key = String.valueOf(freq);
        return key;
    }


    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = new Solution49().groupAnagrams(strs);
        System.out.println(ans);
    }
}
