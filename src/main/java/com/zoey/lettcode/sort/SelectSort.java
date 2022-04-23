package com.zoey.lettcode.sort;

import java.util.Arrays;

public class SelectSort {

    // select sort, time complexity: n^2
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i ++){
            // min_index记录最小值的index
            int min_index = i;
            for (int j = i + 1; j < nums.length; j ++) {
                // 永远跟min_index 所在的值比较，更新min_index的位置，也是升序排列
                if (nums[min_index] > nums[j]) {
                    min_index = j;
                }
            }
            // swap
            int tmp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
