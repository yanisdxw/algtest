package com.interview.linkedList.leetcode_206;

import com.interview.linkedList.ListNode;

public class leetcode_206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int n = arr.length;
        ListNode head = ListNode.createLinkedList(arr,n);
        ListNode.printLinkedList(head);
        ListNode head2 = reverseList(head);
        ListNode.printLinkedList(head2);
    }
}
