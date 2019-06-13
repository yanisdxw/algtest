package com.interview.linkedList.leetcode;

import com.interview.linkedList.ListNode;

public class leetcode_23 {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0||lists==null){
            return null;
        }

        ListNode dummyhead = new ListNode(-100000);

        for(int i=0;i<lists.length;i++){
            mergeTwoLists(dummyhead,lists[i]);
        }

        return dummyhead.next;

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head= null;

        if(l1.val < l2.val){
            head = l1;
            l1=l1.next;
        }else{
            head = l2;
            l2=l2.next;
        }
        ListNode tail=head;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }

        if(l1!=null){
            tail.next=l1;
        }
        else{
            tail.next=l2;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
