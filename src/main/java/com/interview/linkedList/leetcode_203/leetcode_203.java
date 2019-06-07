package com.interview.linkedList.leetcode_203;

import com.interview.linkedList.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

public class leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {

        //特殊判断(不使用虚拟头节点)
//        while (head!=null && head.val==val){
//            ListNode delNode = head;
//            head = delNode.next;
//            delNode.next = null;
//        }
//
//        if(head==null){
//            return null;
//        }

        //使用虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next!=null){
            if(cur.next.val==val){
                //删除cur.next
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
