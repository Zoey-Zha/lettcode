package com.zoey.lettcode.sort;


import java.util.Arrays;


// 这个是top-down 方法，还有bottom-up, iterate??这个没有实现
public class SortArray {

    public int[] sortArray(int[] nums) {

        // Base case
        if (nums.length <= 1) return nums;

        int length = nums.length;

        // 注意copyOfRange() 参数含义，特别是第二个,[)
        int[] left_nums = sortArray(Arrays.copyOfRange(nums,0,length/2));
        int[] right_nums = sortArray(Arrays.copyOfRange(nums,length/2,length));

        return merge(left_nums,right_nums);
    }

    public int[] merge(int[] left, int[] right) {
        // 初始化
        int[] res = new int[left.length + right.length];
        int i = 0,j = 0,k = 0;

        // merge
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res[k++] = left[i++];
            } else{
                res[k++] = right[j++];
            }
        }

        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < right.length) {
            res[k++] = right[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,5,3,4,10,6};

        // int[] newCopy = Arrays.copyOfRange(test,0,test.length/2);
        SortArray sortArray = new SortArray();

        int[] sorted = sortArray.sortArray(test);
        for (int i: sorted)
           System.out.println(i);
    }
}
