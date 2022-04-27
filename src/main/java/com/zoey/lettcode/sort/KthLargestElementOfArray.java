package com.zoey.lettcode.sort;

import java.util.*;

public class KthLargestElementOfArray {

    //Quick sort
    public static int partition(int[] nums, int low, int high) {
        int highsIndex = low - 1;
        int pivot = nums[high];

        for (int i = low; i < high; i++) {
            if (nums[i] >= pivot) {
                highsIndex++;
                // swap(nums[i],nums[highsIndex]);
                int temp = nums[i];
                nums[i] = nums[highsIndex];
                nums[highsIndex] = temp;
            }
        }
        // to do: 为什么swap函数不交换呢？
        // swap(nums[high],nums[highsIndex+1]);
        // System.out.println("middle value " + (highsIndex+1));
        int temp = pivot;
        nums[high] = nums[highsIndex+1];
        nums[highsIndex+1] = temp;

        // System.out.println("nums in after partition " + Arrays.toString(nums));

        return highsIndex + 1;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);


            quickSort(nums, mid+1, high);
            quickSort(nums, low, mid - 1);

        }
    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length -1);
        System.out.println("nums = " + Arrays.toString(nums));
        return nums[k-1];

    }


    // Head,比bubble sort快一些
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

    // Array.sort built in function of Array
    //    public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     int res = nums[nums.length - k];
    //     return res;
    // }

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
        // System.out.println(findKthLargest(nums,3));

        System.out.println("Before swap" + Arrays.toString(nums));

        swap(nums[0], nums[1]); // 交换失败
        System.out.println("After swap" + Arrays.toString(nums));

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i<nums.length; i ++) {
            set.add(nums[i]);
        }

        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext()) {
            int a = iterator.next();
            System.out.println(a);
        }


    }
}

