package com.leetcode;

import com.leetcode.po.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next;
            if(cur.val==next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1,1,1});
        ListNode ans = new Solution83().deleteDuplicates(head);
        System.out.println(ans);
    }
}
