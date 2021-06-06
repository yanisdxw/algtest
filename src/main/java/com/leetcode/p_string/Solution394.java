package com.leetcode.p_string;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Solution394 {
    //数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，
    //字母栈弹到左括号为止。就是逆波兰式那种题。

    /**
     *     public String decodeString(String s) {
     *         StringBuffer  sb = new StringBuffer ();
     *         Stack<Integer> nStack = new Stack<>();
     *         Stack<StringBuffer > sStack = new Stack<>();
     *         int multi = 0;
     *         for (int i = 0; i <s.length() ; i++) {
     *             char c = s.charAt(i);
     *             if(Character.isDigit(c)){
     *                 multi = multi*10+c-'0';
     *             } else if(c=='['){
     *                 nStack.push(multi);
     *                 sStack.push(sb);
     *                 sb = new StringBuffer ();
     *                 multi = 0;
     *             } else if(c==']'){
     *                 StringBuffer  tmp = sStack.pop();
     *                 int m = nStack.pop();
     *                 for (int j = 0; j < m; j++) {
     *                     tmp.append(sb);
     *                 }
     *                 sb = tmp;
     *             } else {
     *                 sb.append(c);
     *             }
     *         }
     *         return sb.toString();
     *     }
     */

    //递归，涉及编译原理
    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }

    public static void main(String[] args) {
        String ans = new Solution394().decodeString("10[le]");
        System.out.println(ans);
    }
}
