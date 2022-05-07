package com.zoey.lettcode.dp;

public class LongestPalindromicSubstring {

    // dp
    public static String longestPalindrome(String str) {
        int n = str.length();
        boolean dp[][] = new boolean[n][n];
        // 记录最长的substring
        int left = 0;
        int right = 0;
        // initial dp array, i == j 及元素本身是对称的
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                  dp[i][j] = true;
            }
        }
        // 这个如果从start = 0开始就会出现dp[start][end]没有值的情况，所以这里倒着来
        //for (int start = 0; start < n; start++) {
        for(int start = n; start >= 0; start--) {
            for (int end = start + 1; end < n; end ++) {
                // 这里不是按照two pointer的思路，而是往后推end,
                // 依据是dp[start+1][end -1] 这个表示的含义是：从start+1到end-1是对称的
                // 或条件是判断两个元素时
                if (str.charAt(start) == str.charAt(end)) {

                    if (end == start + 1 || dp[start+1][end-1]) {
                        // System.out.println("start = " + start + ",end = " + end);
                        dp[start][end] = true;

                        if (end - start > right - left) {
                            left = start;
                            right = end;
                        }
                    }
                }
            }
        }
        // System.out.println("left = " + left + ",right = " + right);
        return str.substring(left, right + 1);
    }



    // two pointer for array
    public static String longestPalindrome1(String s) {
        // record longest substring
        int start = 0;
        int end = 0;
        // 遍历每一个元素
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i - 1;
            int right = i + 1;
            // 向左找所有重复元素
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            // 向右找所有重复元素
            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }
            // 向两边同时找对称元素
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
            }

            // 与目前最长的记录比较，如果大就替换
            left++;
            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }
        // 返回使用string substring方法
        return s.substring(start, end);
    }

    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String s = "aaaa";

        String res =  longestPalindrome(s);
        System.out.println("res = " + res);

    }
}
