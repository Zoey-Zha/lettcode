package com.zoey.lettcode.dp;

public class NthTribonacciNumber {
    public static int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        while (n-- > 2){
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }

    public static void main(String[] args) {
        System.out.println("Res = " + tribonacci(25));
    }
}
