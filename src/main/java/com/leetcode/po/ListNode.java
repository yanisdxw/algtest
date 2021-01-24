package com.leetcode.po;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() { this.val = 0; this.next = null; }
    public ListNode(int val) { this.val = val; this.next = null;}
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode create(int[] num){
        ListNode res = new ListNode();
        res.val = num[0];
        ListNode head = new ListNode(-1, res);
        if(num.length==1){
            return res;
        }
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            res.next = node;
            res = node;
        }
        return head.next;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode tmp = this;
        sb.append(tmp.val+" ");
        while (tmp.next!=null){
            tmp = tmp.next;
            sb.append(tmp.val+" ");
        }
        return sb.toString();
    }
}
