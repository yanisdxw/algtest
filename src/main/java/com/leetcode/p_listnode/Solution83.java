package com.leetcode.p_listnode;

import com.leetcode.po.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
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
