package com.leetcode;

import com.leetcode.po.ListNode;

/**
 * 翻转链表
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //分别找到头和尾
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //找到左边界的前一个节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //左边界节点
        ListNode leftNode = prev.next;
        //右边界节点
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //右边界后一个节点
        ListNode next = rightNode.next;
        //切断要翻转的链表
        prev.next = null;
        rightNode.next = null;
        //单独翻转
        reverseLinkedList(leftNode);
        //再接回去
        prev.next = rightNode;
        leftNode.next = next;
        return dummy.next;
    }

    //翻转链表
    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


    public static void main(String[] args) {
        ListNode node = ListNode.create(new int[]{1,2});
        ListNode newNode = new Solution92().reverseBetween(node,1,2);
        System.out.println(newNode);
    }
}
