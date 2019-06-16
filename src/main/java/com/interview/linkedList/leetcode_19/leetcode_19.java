package com.interview.linkedList.leetcode_19;

import com.interview.linkedList.ListNode;

/**
 * 快慢指针
 */

public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (n>=0){
            p = p.next;
            n--;
        }
        System.out.println(p.val);
        ListNode cur = dummyHead;
        while (p!=null){
            cur = cur.next;
            p = p.next;
        }
        ListNode delNode = cur.next;
        cur.next = cur.next.next;
        delNode.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        ListNode node = ListNode.createLinkedList(arr,arr.length);
        ListNode.printLinkedList(node);
        leetcode_19 solution = new leetcode_19();
        solution.removeNthFromEnd(node,2);
    }
}
