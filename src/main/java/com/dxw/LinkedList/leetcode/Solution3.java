package com.dxw.LinkedList.leetcode;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val, int depth){

        String depthString = genrateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+val+" in "+head);
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return null;
        }
        //removeElements(head.next,val)可以看做是一个删除了val值的链表
        ListNode res = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove "+ val + ": "+res);
        ListNode ret;
        if(head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ret);
        return ret;
    }

//    public ListNode removeElements(ListNode head, int val){
//        if(head==null){
//            return head;
//        }
//        head.next = removeElements(head.next,val);
//        return head.val == val ? head.next:head;
//    }

    private String genrateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Solution3()).removeElements(head,6,0);
        System.out.println(res);
    }
}
