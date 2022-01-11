package com.leetcode.p_string;

public class Solution468 {
    public String validIPAddress(String IP) {
        if(isIPv4(IP)) return "IPv4";
        if(isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String IP){
        String[] strings = IP.trim().split("\\.");
        if(strings.length!=4||IP.charAt(IP.length()-1)=='.') return false;
        for (String s:strings){
            if(s.length()==0||s.length()>3) return false;
            char[] chars = s.toCharArray();
            if(chars[0]=='0'&&chars.length!=1) return false;
            int sum = 0;
            for (char c:chars){
                if(c>='0'&&c<='9'){
                    int t = c-'0';
                    sum = sum*10+t;
                }else {
                    return false;
                }
            }
            if(sum>255) return false;
        }
        return true;
    }

    private boolean isIPv6(String IP){
        String[] strings = IP.trim().split(":");
        if(strings.length!=8||IP.charAt(IP.length()-1)==':') return false;
        for (String s:strings){
            char[] chars = s.toCharArray();
            if(s.length()<1||s.length()>4) return false;
            for (char c:chars){
                if((c<'0')||(c>'9'&&c<'A')||(c>'F'&&c<'a')||(c>'f')){
                    return false;
                }
            }
        }
        return true;
    }
}
