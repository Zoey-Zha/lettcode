package com.zoey.lettcode.sort;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b-a));

        for (int i = 0; i < nums.length; i++) {
            if (heap.size() >= k) {
                list.add(heap.peek());
                heap.remove(nums[i-k]);
            }
            heap.add(nums[i]);
        }
        list.add(heap.peek());

        // Arrays.

        // 返回int[] 一般怎么处理，我这里想到的是使用arraylist转
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum maximum = new SlidingWindowMaximum();
        int[] res = maximum.maxSlidingWindow(nums,10);
        System.out.println("Result = " + Arrays.toString(res));


    }
}
