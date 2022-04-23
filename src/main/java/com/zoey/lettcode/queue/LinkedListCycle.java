package com.zoey.lettcode.queue;

import com.zoey.lettcode.recursion.ListNode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class LinkedListCycle {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // create a hashmap
        HashMap<String, Integer> languages = new HashMap<>();

        // add elements to hashmap
        languages.put("Java", 8);
        languages.put("JavaScript", 1);
        languages.put("Python", 3);
        System.out.println("HashMap: " + languages);

        if (languages.getOrDefault("JavaScript",1) ==1) {
            System.out.println("找到了 javaScript");
        }
        languages.put("Scala",languages.getOrDefault("Scala",1));

        boolean java = languages.containsKey("Java");
        System.out.println("HashMap: " + languages);





    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode oneSpeed = head;
        ListNode twiceSpeed = head.next;
        while (twiceSpeed != null && twiceSpeed.next != null) {
            if (oneSpeed == twiceSpeed) {
                return true;
            }
            oneSpeed = oneSpeed.next;
            twiceSpeed = twiceSpeed.next.next;
        }
        return false;
//        if (head == null || head.next == null) return false;
//
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            // 只需判断fast及fast.next是否是null, 因为这个走的更快，更快遇到null。
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
    }
}
// public boolean hasCycle(ListNode head) {
//         HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();
//         while(head != null) {
//             if (map.containsKey(head)) {
//                 return true;
//             }
//             map.put(head,1);
//             head = head.next;
//         }
//         return false;
//     }