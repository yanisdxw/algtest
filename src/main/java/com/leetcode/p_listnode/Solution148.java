package com.leetcode.p_listnode;

import com.leetcode.Utils;
import com.leetcode.po.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 */
public class Solution148 {

    //优先队列法

    /**
     *     public ListNode sortList(ListNode head) {
     *         PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
     *             @Override
     *             public int compare(ListNode o1, ListNode o2) {
     *                 return o1.val-o2.val;
     *             }
     *         });
     *         ListNode cur = head;
     *         while (cur!=null){
     *             priorityQueue.add(cur);
     *             cur = cur.next;
     *         }
     *         ListNode pre = new ListNode(-1);
     *         head = pre;
     *         while (!priorityQueue.isEmpty()){
     *             ListNode node = priorityQueue.poll();
     *             pre.next = node;
     *             pre = node;
     *         }
     *         pre.next = null;
     *         return head.next;
     *     }
     */

    //归并排序法
    public ListNode sortList(ListNode head){
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode r, l;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        r = mergeSort(slow.next);
        slow.next = null;
        l = mergeSort(head);
        return merge(l,r);
    }

    private ListNode merge(ListNode l, ListNode r){
        ListNode tmp = new ListNode(-1);
        ListNode headtmp = tmp;
        while (l!=null && r!=null){
            if(l.val>r.val){
                tmp.next = r;
                r = r.next;
            }else {
                tmp.next = l;
                l = l.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l==null?r:l;
        return headtmp.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
//        Utils.printListNode(node1);
        ListNode head = new Solution148().sortList(node1);
        Utils.printListNode(head);
    }
}
