package com.zoey.lettcode.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        // 一般有dummy/哨兵就是这样操作，既能保持头，也能做其他操作
        // new node = dummy
        ListNode current = res;

        int mod = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + mod;
                l2 = l2.next;
            }
            else if (l2 == null) {
                sum = l1.val + mod;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + mod;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum%10);
            current.next = node;
            current = current.next;

            mod = sum/10;

        }
        if (mod > 0) current.next = new ListNode(mod);

        return res.next;
    }

    public ListNode reverseList(ListNode l1) {
        if (l1 == null) return l1;
        if (l1.next == null) return l1;

        ListNode res = reverseList(l1.next);
        l1.next.next = l1;
        l1.next = null;

        return res;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        AddTwoNumbers numbers = new AddTwoNumbers();
//        Reverse 没问题
//        ListNode test = numbers.reverseList(l1);
//        while (test != null) {
//            System.out.println(test.val);
//            test = test.next;
//        }

        ListNode res = numbers.addTwoNumbers(l1,l2);
        while (res != null) {
            System.out.println("res = " + res.val);
            res = res.next;
        }
        //System.out.println("test%: " + 11%10);
        // System.out.println("test /: " + 11/10);

    }
}
