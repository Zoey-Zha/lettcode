package com.zoey.lettcode.sort;

import java.util.Arrays;

public class BubbleSort {
    // 冒泡排序
    // 跟select sort相比，他俩循环体是一样的，不过select不是比较一次就交换一直，
    // 而是最后里面一轮loop结束之后才交换
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                // ascending order
                if (nums[i] > nums[j]) {
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4,5,1,9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
