package com.zoey.lettcode;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        int[] bits = new int[n+1];

        for (int i = 0; i <= n; i++){
            int count = Integer.bitCount(i);
            // System.out.println("i = " + i + ", bit count = " + count);
            bits[i] = count;
        }


    }
}
