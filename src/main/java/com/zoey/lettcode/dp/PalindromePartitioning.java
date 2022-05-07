package com.zoey.lettcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int start = n - 1; start >= 0; start --) {
            for (int end = start + 1; end < n; end ++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (dp[start + 1][end -1] || end == start + 1) {
                        dp[start][end] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) {

            }
            System.out.println(Arrays.toString(dp[i]));
        }

        List<List<String>> list = new ArrayList<>();
        return list;

    }

    public static void main(String[] args) {
        String s = "aabba";
        partition(s);
    }

}
