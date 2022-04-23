package com.zoey.lettcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementOfArray {

    // Head,比bubble sort快一些
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

    // Bubble sort
    public static int findKthLargest1(int[] nums, int k) {
        for (int i = 1; i <= k; i ++) {
            for (int j = 0; j < nums.length - i; j ++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        int res = nums[nums.length - k];
        return res;
    }

    public static void main(String[] args) {
        int[] test = {3,2,1,5,6,4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        // Arrays.sort(nums);
        //System.out.println(findKthLargest(test,2));
        // System.out.println(findKthLargest1(nums,7));
        System.out.println(findKthLargest(nums,3));
        System.out.println(Arrays.toString(nums));
    }
}

