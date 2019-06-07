package com.interview.linkedList.leetcode_24;

import com.interview.linkedList.ListNode;

public class leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next!=null && p.next.next!=null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            //node1是交换位置后靠后的节点
            p = node1;
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }
}
