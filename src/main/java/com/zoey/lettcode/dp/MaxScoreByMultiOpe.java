package com.zoey.lettcode.dp;

import java.util.Arrays;

public class MaxScoreByMultiOpe {
    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i-left);
                dp[i][left] = Math.max(mult*nums[left] + dp[i+1][left+1],
                                       mult*nums[right] + dp[i+1][left]);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = {-5,-3,-3,-2,7,1}, multipliers = {-10,-5,3,4,6};
        int res = maximumScore(nums, multipliers);
        System.out.println("res = " + res);
    }


}
