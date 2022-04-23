package com.zoey.lettcode.string;

import java.util.*;

public class LongestSubstring {

    /**
     * Based on HashMap，还有一直更新start位置
     * @param s
     * @return
     */
    public int newLengthOfLongestSubstring(String s){
        // 记录substring最长长度
        int longest = 0;
        // key: char, value: i
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 记录没有重复的substring的start position
        int start = 0;
        // int end = 0; end = i;

        for (int i = 0; i < s.length(); i++) {
            // 有重复值
            if (hashMap.containsKey(s.charAt(i))) {
                // 去当前substring的最大长度，并且与历史比较
                longest = Math.max(longest, i - start);
                // 更新start position
                start = Math.max(hashMap.get(s.charAt(i)) + 1,start);
                // repalce or put都可以吧
                hashMap.replace(s.charAt(i),i);
            }
            hashMap.put(s.charAt(i),i);
        }
        // 结束之后再取一次最大值，并返回
        longest = Math.max(longest, s.length() - start);
        return longest;
    }

    /**
     * Based on Queue
     * @author zoey
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Queue<Character> longestSub = new LinkedList<>();

        for (int i = 0; i < s.length(); i ++) {
            if (longestSub.contains(s.charAt(i))) {
                longest = Math.max(longest, longestSub.size());
                // 重复值之前的元素都从队列移除
                while(longestSub.peek() != s.charAt(i)) {
                    longestSub.poll();
                }
                longestSub.poll();

                longestSub.add(s.charAt(i));
            }
            else {
                longestSub.add(s.charAt(i));
            }
        }
        longest = Math.max(longest, longestSub.size());
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();

        // String s = "abcabcbb";
        // String s = "pwwkew";
        // String s = " ";
        //String s = "abc";
        // String s = "";
        //String s = "dvdf";
        String s = "dvdfevedv";

        //System.out.println("Queue = " + substring.lengthOfLongestSubstring(s));
        // System.out.println("HashMap = " + substring.newLengthOfLongestSubstring(s));

        // <Integer> 放在Queue和LinkedList有什么区别
        // 第一次放到LinkedList时，q.peek() !=2 一直报错
        // 这个问题注意一下
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Before 队列是否包含1: " + q.contains(2));
        if (q.contains(2)) {
            while(q.peek()!=2) {
                q.poll();
            }
            q.poll();
        }
        System.out.println("After 队列是否包含1: " + q.contains(2));
    }
}
