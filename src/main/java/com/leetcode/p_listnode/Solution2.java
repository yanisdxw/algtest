package com.leetcode.p_listnode;

import com.leetcode.po.ListNode;

public class Solution2 {

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int m = 0; int n = 0;
        ListNode tmp = new ListNode(-1);
        ListNode head = tmp;
        while(l1!=null && l2!=null){
            int v1 = l1.val;
            int v2 = l2.val;
            int res = v1 + v2 + n;
            m = res%10;
            n = res/10;
            ListNode p = new ListNode(m);
            tmp.next = p;
            tmp = p;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int res = l1.val + n;
            m = res%10;
            n = res/10;
            ListNode p = new ListNode(m);
            tmp.next = p;
            tmp = p;
            l1 = l1.next;
        }
        while(l2!=null){
            int res = l2.val + n;
            m = res%10;
            n = res/10;
            ListNode p = new ListNode(m);
            tmp.next = p;
            tmp = p;
            l2 = l2.next;
        }
        if(n!=0){
            ListNode p = new ListNode(1);
            tmp.next = p;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = toInt(l1);
        int v2 = toInt(l2);
        int sum = v1 + v2;
        return toListNode(sum);
    }

    //链表转int
    public static int toInt(ListNode l){
        int i = 1;
        int val = l.val;
        int res = i*val;
        while(l.next!=null){
            l = l.next;
            val = l.val;
            i=i*10;
            res += i*val;
        }
        return res;
    }

    //int转链表
    public static ListNode toListNode(int l){
        int m = l%10;
        int n = l/10;
        ListNode res = new ListNode(m);
        ListNode head = res;
        while(n>0){
            m = n%10;
            n = n/10;
            ListNode node = new ListNode(m);
            res.next = node;
            res = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.create(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = ListNode.create(new int[]{9,9,9,9});
        ListNode l3 = addTwoNumbers2(l1,l2);
        System.out.println(l3);
    }
}
