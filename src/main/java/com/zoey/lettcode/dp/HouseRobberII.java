package com.zoey.lettcode.dp;

public class HouseRobberII {
    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // 从index=0到nums.length-1,排除最后一个元素
        int preTwo = nums[0];
        int preOne = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length-1; i++) {
            int temp = preOne;
            preOne = Math.max(preOne, preTwo + nums[i]);
            preTwo = temp;
        }

        // 从index开始到结束，排除了index=0
        int two = nums[1];
        int one = Math.max(nums[2],nums[1]);
        for (int i = 3; i < nums.length; i++) {
            int temp = one;
            one = Math.max(two+nums[i],one);
            two = temp;
        }

        return Math.max(preOne, one);
    }
}
