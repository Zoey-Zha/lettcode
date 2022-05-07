package com.zoey.lettcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubsequence {

    private int[][] memo;

    // top down
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        // 这里的m+1,n+1, 因为我们要初始化边界，所以增加一行一列作为辅助列
        // 这个做法在2D array还是很常见，特别是不实用递归的做法
        memo = new int[m + 1][n + 1];

        // initial memo, 0
        // 辅助列初始化值为0
        for (int i = 0; i < m; i ++) {
            memo[i][0] = 0;
        }
        Arrays.fill(memo[0], 0);

        // 这里的时间复杂度是o(m*n)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j-1]);
                }
            }
        }
        // 返回右下角的值
        return memo[m][n];
    }

    // bottom up
    public int longestCommonSubsequence1(String text1, String text2) {

        int m = text1.length(), n = text2.length();

        memo = new int[m][n];

        // inital memo
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(text1, 0, text2, 0);
    }

    /**
     * text1: from i to end, text2: from j to end, how long the longest subsequence is
     * @param text1
     * @param i
     * @param text2
     * @param j
     * @return
     */
    public int dp(String text1, int i, String text2, int j) {
        //base case
        if (i == text1.length() || text2.length() == j) {
            return 0;
        }

        if(memo[i][j] != -1) return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            memo[i][j] = Math.max(dp(text1, i+1, text2, j),
                    dp(text1, i, text2, j + 1));
        }

        return memo[i][j];
    }

    public static void main(String[] args) {

        String text1 = "oxcpqrsvwf";
        String text2 = "shmtulqrypy";
        LongestCommonSubsequence example = new LongestCommonSubsequence();
        int res = example.longestCommonSubsequence(text1,text2);
        System.out.println("res = " + res);
    }
}
