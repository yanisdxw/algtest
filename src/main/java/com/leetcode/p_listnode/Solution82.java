package com.leetcode.p_listnode;

import com.leetcode.po.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  * 输入：head = [1,2,3,3,4,4,5]
 *  * 输出：[1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            ListNode next = cur.next;
            if(next.val==cur.val){
                int repeat = cur.val;
                while (cur!=null && cur.val==repeat){
                    cur = cur.next;
                }
                prev.next = cur;
            }else {
                prev = cur;
                cur = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1,1,1,2,3});
        ListNode ans = new Solution82().deleteDuplicates(head);
        System.out.println(ans);
    }

}
