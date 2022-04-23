package com.zoey.lettcode.recursion;

public class SwapNodesinPairs {


    // 不借助其他方法递归
    // 对于LinkedList来说，跟之前的reverse linkedlist类似，都是采用的bottom-up的方式
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;

    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head.next;

        // preNode可以用fakeHead, fakeHead.next不会被改变
        // ListNode preNode = new ListNode(-1);

        helper(fakeHead,head,head.next);

        return fakeHead.next;
    }

    public void helper(ListNode preNode, ListNode first, ListNode second) {
        if (first == null || second == null) return;

        ListNode tmp = second.next;
        second.next = first;
        first.next = tmp;
        preNode.next = second;

        if (first.next == null) return;
        helper(first,first.next,first.next.next);
    }

}

// 因为这个是top-down问题，loop方法也是可以的
//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null) return head;
//
//        if(head.next == null) return head;
//
//        // fake-head, 保留要返回的head
//        ListNode fakeHead = new ListNode(0);
//        fakeHead.next = head.next;
//
//        // fake preNode, for the nodes going to swap
//        ListNode preNode = new ListNode(0);
//
//        ListNode first = head;
//        ListNode second = head.next;
//
//        while (first != null && second != null) {
//            // 交换过程
//            ListNode tmp = second.next;
//            second.next = first;
//            first.next = tmp;
//            preNode.next = second;
//
//            // 交换结束
//            preNode = first;
//            // 避免null 引用，比如second的值
//            if (first.next != null) {
//                first = first.next;
//                second = first.next;
//            }
//            else break;
//        }
//        return fakeHead.next;
//    }
//}
