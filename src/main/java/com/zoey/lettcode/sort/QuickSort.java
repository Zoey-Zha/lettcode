package com.zoey.lettcode.sort;

import java.util.Arrays;

public class QuickSort {
    // find the partition position
    public int partition (int[] nums, int low, int high) {

        // before(include) i are nums than pivot
        // 我觉得这个变量是比较tricky的，因为这个变量只有nums[i] < pivot的时候才会自增
        // 那么就表示或者说可以肯定的是：low to lowsIndex的值都比pivot小
        // 同时for loop 保证了每一个比pivot小的值都被移动到前面了。
        // 中间比pivot大的值可能有多次移动
        int lowsIndex = low - 1;
        // 选取pivot
        int pivot = nums[high];

        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                lowsIndex ++;
                //swap
                int temp = nums[lowsIndex];
                nums[lowsIndex] = nums[i];
                nums[i] = temp;
            }
        }
        // 遍历结束后，从low到lowsIndex都是比pivot小的数
        // 接下来要把pivot换到中间，使得pivot左侧都是比pivot小的nums, pivot右侧都是比pivot大
        int temp = nums[lowsIndex+1];
        nums[lowsIndex+1] = nums[high];
        nums[high] = temp;

        return lowsIndex + 1;
    }

    // 也是一个经典的分而治之算法？
    // 每次都是首先借助helper把问题分为两部分分别处理
    // 截止到这里，我觉得对于分而治之算法，找到一个分割点很重要，把问题分成2个或者多个处理。
    // 这个时候通常也会不断递归
    public void quickSort(int[] nums, int low, int high) {
       if (low < high) {
           // 找到分而治之的点分隔成subproeblems, 然后再继续分
           int partition = partition(nums, low, high);

           quickSort(nums, low,partition-1);
           quickSort(nums, partition+1,high);

       }
    }

    public static void main(String[] args) {
        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        QuickSort qs = new QuickSort();
        qs.quickSort(data, 0, data.length-1);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(data));

    }
}
