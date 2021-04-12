package com.leetcode.p_priorityqueue;

import com.leetcode.po.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode list:lists){
            if(list!=null){
                priorityQueue.add(list);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode dumy = head;
        while (!priorityQueue.isEmpty()){
            ListNode listNode = priorityQueue.poll();
            ListNode top = listNode;
            ListNode second = top.next;
            if(second!=null){
                priorityQueue.add(second);
            }
            top.next = null;
            head.next = top;
            head = top;
        }
        return dumy.next;
    }
}
