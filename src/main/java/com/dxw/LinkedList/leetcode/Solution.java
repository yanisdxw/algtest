package com.dxw.LinkedList.leetcode;

public class Solution {
    public ListNode removeElements(ListNode head, int val){

        //开始要删除的节点
        while(head!=null && head.val==val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        //全删空了
        if(head==null){
            return head;
        }
        ListNode prev = head;
        while (prev.next!=null){
            //判断后一个节点是不是要删除
            if(prev.next.val==val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                //如果删除不需要向前
            }else {
                //如果没有删除，prev向前
                prev = prev.next;
            }
        }

        return head;
    }
}
