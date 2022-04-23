package com.zoey.lettcode.map;

import com.zoey.lettcode.recursion.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 20;
        // int n = 19;
        long res = (long)n;
        boolean happyNumber;
        HashSet<Long> set = new HashSet<>();
        HashSet<ListNode> listNodes = new HashSet<>();
        // listNodes.contains(a)

        while ( res != 1 && !set.contains(res)) {
            set.add(res);
            String tmp = Long.toString(res);
            res = 0L;
            System.out.println("tem = " + tmp);
            for (int i = 0; i < tmp.length(); i++){
                char c = tmp.charAt(i);
                int a = Character.getNumericValue(c);
                res += a*a;
                // System.out.print("c=" +a + ", res = " + res + "\n");
            }
        }
        // System.out.println("set: " + set);

        happyNumber = res ==1? true:false;
        if(happyNumber) System.out.println("Happy!!");
        else System.out.println("Unhappy!!");


//        set.add(20L);
//        set.add(10L);
//        set.add(5L);
//
//        if(set.contains(5)) {
//            System.out.println("Happy!!");
//        }

    }
}
