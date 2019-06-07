package com.interview.linkedList.leetcode_237;

import com.interview.linkedList.ListNode;

public class leetcode_237 {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }

        if(node.next==null){
            node = null;
            return;
        }

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
}
