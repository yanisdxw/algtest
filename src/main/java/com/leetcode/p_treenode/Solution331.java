package com.leetcode.p_treenode;

import java.util.List;

public class Solution331 {

    private int k = 0;
    private String s;
    private boolean ans = true;
    public boolean isValidSerialization(String preorder) {
        s = preorder+",";
        dfs();
        return ans && k==s.length();
    }

    private void dfs(){
        if(k==s.length()) {
            ans = false;
            return;
        }
        if(s.charAt(k)=='#'){
            k+=2;
            return;
        }
        while (s.charAt(k)!=',') {
            k++;
        }
        k++;
        dfs();
        dfs();
    }
}
