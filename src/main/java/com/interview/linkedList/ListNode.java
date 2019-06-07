package com.interview.linkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode createLinkedList(int[] arr, int n){
        if(n==0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
