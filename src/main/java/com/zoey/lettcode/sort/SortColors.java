package com.zoey.lettcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColors {
    // two pointer
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // int end = right;
            for (int end = right; end > left; end --) {
                if (nums[end] == 0 && nums[left] > 0 ){

                }
            }


        }

        for (int i = 0; i < nums.length; i++) {

        }
    }


    public static void sortColors1(int[] nums) {
        // 对这个申请方式还是不清楚
        // 数组
        // 数据类型为ArrayList<Integer>, 即数组中每一个元素都是ArrayList<Integer>
        // 后面还有对每一个数组元素初始化，bucket[i] = new ArrayList<Integer>()
        ArrayList<Integer>[] bucket = new ArrayList[3];

        // Create empty buckets
        for (int i = 0; i < 3; i++)
            bucket[i] = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]].add(nums[i]);
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i ++) {
            for (int ele : bucket[i]) {
                nums[index++] = ele;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2,0,1};
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
