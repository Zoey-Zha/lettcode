package com.zoey.lettcode.sort;

import java.util.PriorityQueue;

public class KthLargestInStream {
    private int k;
    // int[] nums;
    private PriorityQueue<Integer> heap;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>((a, b) -> (a-b));
        // array heapify
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) heap.add(nums[i]);
            else if (heap.size() >= k && nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
            // 写了两个if,导致重复添加，所以一定要保证第一个if执行完后不会满足第二个if,才用两个if
            // 否则还是用if ... els if (else) 要不然会重复执行
        }

    }

    public int add(int val) {
        if (heap.size() < k) heap.add(val);
        else if (heap.size() >= k && val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargestInStream stream = new KthLargestInStream(3, nums);
        System.out.println("res after add 3: " + stream.add(3));
    }
}
