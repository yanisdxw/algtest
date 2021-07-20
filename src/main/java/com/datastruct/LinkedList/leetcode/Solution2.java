package com.datastruct.LinkedList.leetcode;

public class Solution2 {
    //使用虚拟头结点
    public ListNode removeElements(ListNode head, int val){

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
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

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Solution()).removeElements(head,6);
        System.out.println(res);
    }
}
