package com.leetcode;

import com.leetcode.po.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        //先获取链表的长度
        ListNode cur = head;
        while (cur!=null){
            cur = cur.next;
            len++;
        }
        if(len==0) return head;
        //通过对长度做模运算取要断开的位置
        int mod = k%len;
        //如果模为0,不需要翻转
        if(mod==0){
            return head;
        }
        //通过要前进的步数step找到需要断开的位置prev
        int step = len - mod;
        ListNode prev = head;
        while (--step!=0){
            prev = prev.next;
        }
        //next是下一段开始的节点，即新链表头
        ListNode next = prev.next;
        //这里要断开上一段
        prev.next = null;
        cur = next;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1,2,3});
        int k = 2;
        ListNode ans = new Solution61().rotateRight(head,k);
        System.out.println(ans);
    }
}
