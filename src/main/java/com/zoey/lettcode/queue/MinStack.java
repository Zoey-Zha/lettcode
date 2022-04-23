package com.zoey.lettcode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinStack{

    // MinStack implementation in Java


    private int arr[];
    private int top;
    private int capacity;

    public MinStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    // Add elements into stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
    // Remove element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        return arr[top--];
    }

    // Utility function to return the size of the stack
    public int size() {
        // Arrays.stream(arr).sorted();
        return top + 1;
    }

    // Check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public int getMin() {
        int min = arr[0];
        for (int i = 0; i <= top; i ++) {
           if (min > arr[i]) min = arr[i];
            //System.out.println("min = " + min);
        }
        return min;

    }

    public static void main(String[] args) {
//        ArrayDeque<Integer> dd = new ArrayDeque<Integer>();
//        dd.add(1);
//
//        MinStack stack = new MinStack(5);
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        stack.printStack();
//
//        //stack.pop();
//        // System.out.println("\nAfter popping out");
//        int min = stack.getMin();
//        System.out.println("min = " + min);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(2);

        // System.out.println("queue = " + queue.peek());
        System.out.println(queue.poll());


    }
}
