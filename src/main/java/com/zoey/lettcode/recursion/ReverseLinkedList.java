package com.zoey.lettcode.recursion;

import java.util.Iterator;
import java.util.List;

public class ReverseLinkedList {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 保存head
            ListNode p = reverseList(head.next);
            // head.next.next = head 实现了回指，反向指，这个是关键点
            head.next.next = head;
            head.next = null;
            return p;
        }
        // 这样的方式虽然简单，但把new head丢了。。
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        System.out.println("head.val = " + head.val);
        ListNode node = reverseList1(head.next);
        //System.out.println("head.val = " + head.val);
        //System.out.println("node.val = " + node.val);
        node.next = head;
        head.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        ListNode newHead = new ReverseLinkedList().reverseList1(head);
        // System.out.println(newHead.val);

        while(newHead!=null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

        // head = [1,2,3,4,5], parameter为head.next,可知：
        // 1. reverseList(5)=5;
        // 2. reverseList(4)=5;   1，2，3，4，5，4，null
        // 3. reverseList(3)=5;   1, 2, 3     ｜
        // 4. reverseList(2)=5;
        // 5. reverseList(1)=5;

        // while head = 4, parameter: head.next == 5, p= reverserList(5), return 5, p =5;
        // 执行递归后的部分，head.next.next = 4; 形成1，2，3，4 ｜｜｜ 5，4，null，也就是两个node指向4



}
