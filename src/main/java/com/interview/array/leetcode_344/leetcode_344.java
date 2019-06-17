package com.interview.array.leetcode_344;

public class leetcode_344 {
    public void reverseString(char[] s) {

        if(s==null||s.length==0) return;

        for(int i=0;i<s.length/2;i++){
            swap(s,i,s.length-i-1);
        }
    }

    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
