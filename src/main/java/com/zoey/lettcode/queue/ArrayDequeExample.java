package com.zoey.lettcode.queue;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // ArrayDeque<String> stack = new ArrayDeque<String>();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //String s = "()[]{}";
        String s = "()";
        // String转为数组
        char[] chars = s.toCharArray();
        // Char 转为int, 方便后续处理
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i ++) {
            switch (chars[i]) {
                case '(': ints[i] = -1; break;
                case ')': ints[i] = 1; break;
                case '{': ints[i] = -2; break;
                case '}': ints[i] = 2; break;
                case '[': ints[i] = -3; break;
                case ']': ints[i] = 3; break;
                default: ints[i] = 0; break;
            }
        }

        // if (chars.length > 0) stack.push(ints[0]);

        for (int i = 0; i < ints.length; i++ ){
            // System.out.println(stack.peek());
            //&& (ints[i] + stack.peek()) == 0
            if (stack.size() > 0 && stack.peek() < 0 && (ints[i] + stack.peek()) == 0){
                stack.pop();
                // System.out.println(stack.peek());
            }
            else stack.push(ints[i]);
        }
        
//        stack.add(1);
//        stack.add(2);
//        stack.add(-2);
//        stack.add(-1);
//        stack.add(-3);
//        stack.add(3);


        // Add elements to stack
//        stack.push("Dog");
//        stack.push("Cat");
//        stack.push("Horse");
        System.out.println("Stack: " + stack);

        if (stack.size() == 0) {
            System.out.println("A good pair of brackets");
        }
        else System.out.println("Not a pairs");

        // Access element from top of stack
        // String element = stack.peek();
        // System.out.println("Accessed Element: " + element);

        // Remove elements from top of stack
        // String remElement = stack.pop();
        // System.out.println("Removed element: " + remElement);
    }
}
