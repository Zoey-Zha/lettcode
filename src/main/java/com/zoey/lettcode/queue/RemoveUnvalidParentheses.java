package com.zoey.lettcode.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class RemoveUnvalidParentheses {
    static String minRemoveToMakeValid(String s) {

        // ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
        ArrayDeque<Character> stack = new ArrayDeque<>();

        ArrayList<Character> chars = new ArrayList<Character>();
        // ArrayDeque<Character> chars1 = new ArrayDeque<>(s.length());
        ArrayDeque<Character> chars1 = new ArrayDeque<>(); // withiout length

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            switch (s.charAt(i)) {
                case '(':
                    stack.push(c);
                    chars.add(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        chars.add(c);
                    }
                    break;
                default:
                    chars.add(c);
            }
        }
        if (stack.isEmpty() && chars.isEmpty()) {
            return "";
        }
        else if (stack.isEmpty() && !chars.isEmpty()) {
            // ArrayList<Character> 如何转化为String, 这里是否耗费时间
            String res = chars.get(0).toString();
            for (int i = 1; i < chars.size(); i++) res = res.concat(chars.get(i).toString());
            // System.out.println("测试返回是否为String: " + res);
            return res;
        }
        else {
            stack.clear();
            // System.out.println("chars: " + chars);
            for (int i = chars.size() - 1; i >= 0; i --) {
                char c = chars.get(i);
                // System.out.println("c in chars: " + c);
                switch (c) {
                    case ')':
                        stack.push(c);
                        chars1.push(c);
                        break;
                    case '(':
                        if (!stack.isEmpty() && stack.peek() == ')') {
                            stack.pop();
                            chars1.push(c);
                        }
                        break;
                    default:
                        chars1.push(c);
                        break;
                }
            }
            String res = "";
            System.out.println("chars1: " + chars1);
            int length = chars1.size();
            System.out.println("length of chars1: " + length);
            for (int i = 0; i < length; i ++) {
                System.out.println("i = " + i);
                res = res.concat(chars1.poll().toString());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        // String s = "lee(t(c)o)de)";
        // String s = "a)b(c)d";
        // String s = "(a(b(c)d)";
        // String s = "))((";
        // String s = "((a(c)b)d";
        // String s = ")))))";
        String s = ")())()(())))()())))(w(()())())e(o()))d))()))()))";
        System.out.println("s = " + s);
        System.out.println(minRemoveToMakeValid(s));
    }
}
