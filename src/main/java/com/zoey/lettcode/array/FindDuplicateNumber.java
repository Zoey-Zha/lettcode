package com.zoey.lettcode.array;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4};
        // int [] nums = {3,1,3,4,2};
        // int[] nums = {2,2,2,2,2};

        int slow = nums[0];
        int fast = nums[1];
        for (int i = 0; i < nums.length; i ++) {
            if(slow == fast) break;
            slow = nums[i];
            fast = nums[(i+1)%nums.length];
            System.out.println("slow = " + slow + ", fast = " + fast);
        }
        System.out.println("duplicate = " + slow);
    }
}
