package com.zoey.lettcode.dp;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // int[] res = new int[nums.length];
        // 用了两个变量后竟然比数据的Memory多！！
        int preTwo = nums[0];
        int preOne = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++) {
            int temp = preOne;
            preOne = Math.max(preTwo+nums[i], preOne);
            preTwo = temp;
        }

        return preOne;
    }
}
