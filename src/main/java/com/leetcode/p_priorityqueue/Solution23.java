package com.leetcode.p_priorityqueue;

import com.leetcode.po.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 */
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
