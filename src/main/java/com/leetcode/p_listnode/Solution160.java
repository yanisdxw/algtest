package com.leetcode.p_listnode;

import com.leetcode.po.ListNode;

/**
 * 相交链表
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //先分别遍历2个链表，记录各自的长度
        ListNode dummyA = headA;
        int A = 0;
        ListNode dummyB = headB;
        int B = 0;
        while (dummyA!=null){
            dummyA = dummyA.next;
            A++;
        }
        while (dummyB!=null){
            dummyB = dummyB.next;
            B++;
        }
        if(A==0||B==0) return null;
        dummyA = headA;
        dummyB = headB;
        if(A>B){
            int diff = A-B;
            while (diff-->0){
                dummyA = dummyA.next;
            }
        }else {
            int diff = B-A;
            while (diff-->0){
                dummyB = dummyB.next;
            }
        }
        if(dummyA!=null&&dummyB!=null&&dummyA==dummyB) return dummyA;
        while (dummyA!=null && dummyB!=null){
            dummyA = dummyA.next;
            dummyB = dummyB.next;
            if(dummyA==dummyB) return dummyA;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = ListNode.create(new int[]{3});
        ListNode headB = ListNode.create(new int[]{2});
        headB.next = headA;
        ListNode node = new Solution160().getIntersectionNode(headA,headB);
        System.out.println(node);
    }
}
